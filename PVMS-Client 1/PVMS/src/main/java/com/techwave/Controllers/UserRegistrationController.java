package com.techwave.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techwave.Urls;
import com.techwave.Models.BAO.CaptchaResponse;
import com.techwave.Models.Pojos.LoginUser;
import com.techwave.Models.Pojos.UpdatePwdUsers;
import com.techwave.Models.Pojos.UsersRegistrations;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({ "userIdSessionNo", "userIdSession" })
public class UserRegistrationController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String home() {
		return "Home";
	}

	@RequestMapping("/contactUs")
	public String contactus() {
		return "contactUs";
	}

	@RequestMapping("/aboutus")
	public String AboutUs() {
		return "AboutUs";
	}

	@RequestMapping("/register")
	public String registerUser(Model M) {
		UsersRegistrations ur = new UsersRegistrations();
		M.addAttribute("url", ur);
		return "registerUser";
	}

	@RequestMapping("/UserValidate")
	public String UserValidate(@Valid @ModelAttribute("url") UsersRegistrations url, BindingResult bs, Model M,
			RedirectAttributes redirectAttributes, @RequestParam("g-recaptcha-response") String captcha) {
		if (bs.hasErrors()) {
			return "registerUser";
		}
		try {

			String URL = "https://www.google.com/recaptcha/api/siteverify";
			String params = "?secret=6Le-ImopAAAAAH7PDNZo7o78u3vAKWAFgLdK0pdz&response=" + captcha;
			CaptchaResponse resp = restTemplate.postForObject(URL + params, null, CaptchaResponse.class);
			if (resp.isSuccess()) {

				ResponseEntity<String> responseEntity = restTemplate.postForEntity(Urls.registerUser, url,
						String.class);
				redirectAttributes.addFlashAttribute("msg", responseEntity.getBody());
				return "redirect:/";
			} else {
				M.addAttribute("Error", "Invalid Captcha!");
				return "registerUser";
			}
		} catch (HttpClientErrorException E) {
			M.addAttribute("msg", E.getResponseBodyAsString());
			return "registerUser";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginU", loginUser);
		return "login";
	}

	@RequestMapping("/loginValidate")
	public String loginValidate(@Valid @ModelAttribute("loginU") LoginUser loginU, BindingResult bs, Model M,HttpSession session) {
		if (bs.hasErrors()) {
			return "login";
		}
		try {

			ResponseEntity<UsersRegistrations> responseEntity = restTemplate.getForEntity(Urls.getUserById,
					UsersRegistrations.class, Map.of("id", loginU.getUserId()));
			UsersRegistrations user = responseEntity.getBody();

			if (user != null && passwordEncoder.matches(loginU.getPassword(), user.getPassword())) {
				if ("N".equals(user.getStatus())) {
					// Redirect to update password page
					M.addAttribute("userIdSessionNo", user.getUserId());
					return "redirect:/updatePassword";
				} else {
					// Redirect to another page (e.g., Home)
					M.addAttribute("userIdSession", user.getUserId());
					
					return "redirect:/Services";
				}
			} else {
				// Login failed, handle accordingly (e.g., show error message)
				M.addAttribute("error", "Invalid Credentials");
				return "login"; // Replace with your login page name
			}
		} catch (HttpClientErrorException e) {
			// TODO: handle exception
			M.addAttribute("error", e.getResponseBodyAsString());
			return "login";
		}
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(Model M,HttpSession session) {
		String userId = (String) session.getAttribute("userIdSessionNo");
	    if (userId == null) {
	        return "redirect:/login";
	    }
		UpdatePwdUsers upu = new UpdatePwdUsers();
		M.addAttribute("upu", upu);
		M.addAttribute("userId",userId);
		return "updatePassword";
	}

	@RequestMapping("/updateValidate")
	public String updateValidate(@Valid @ModelAttribute("upu") UpdatePwdUsers upu, BindingResult bs,
		 RedirectAttributes ra,HttpSession session,SessionStatus status) {
		 String userId = (String) session.getAttribute("userIdSessionNo");
		    if (userId == null) {
		        return "redirect:/login";
		    }
		if (bs.hasErrors()) {
			return "updatePassword";
		}
		restTemplate.put(Urls.updatePassword, upu, Map.of("id", userId));
		ra.addFlashAttribute("msg", "Your password has updated successfully..");
		status.setComplete();
		return "redirect:/login";
	}

}
