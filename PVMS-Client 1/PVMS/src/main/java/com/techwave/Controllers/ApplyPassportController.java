package com.techwave.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techwave.Urls;
import com.techwave.Models.Pojos.Passport;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"userIdSession" })
public class ApplyPassportController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/ApplyPassport")
	public String applyPassport(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	    String userId = (String) session.getAttribute("userIdSession");
	    if (userId == null) {
	        return "redirect:/";
	    }

	    String message = restTemplate.getForEntity(Urls.getPassport, String.class, Map.of("userId", userId)).getBody();
	    if (message == null) {
	        Passport user = new Passport();
	        model.addAttribute("user", user);
	        model.addAttribute("userId", userId);
	        return "ApplyPassportForm";
	    }
	    redirectAttributes.addFlashAttribute("message", message);
	    return "redirect:/Services";
	}

	
	@RequestMapping("/ApplyPassportForm")
	public String createpassport(@Valid @ModelAttribute("user") Passport user,BindingResult bs, Model M, HttpSession session,RedirectAttributes redirectAttributes) {		
		
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		
		if(bs.hasErrors()) {
			return "ApplyPassportForm";
		}
		
			String user_data = restTemplate.postForEntity(Urls.applyPassport, user, String.class, Map.of("userId", userId)).getBody();
			redirectAttributes.addFlashAttribute("message", user_data);
			return "redirect:/Services";
	}
	
	   @RequestMapping("/Logout")
	    public String logout(SessionStatus status) {	       
		   status.setComplete();
	        return "redirect:/";
	    }
}
