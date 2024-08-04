package com.techwave.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techwave.Urls;
import com.techwave.Models.Pojos.Passport;
import com.techwave.Models.Pojos.VisaCancellation;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({ "userIdSession", "passportId" })
public class CancelVisaController {

	@Autowired
	RestTemplate resttemplate;

	@RequestMapping("/CancelVisa")
	public String fetchvisa(HttpSession session, Model M,
			RedirectAttributes redirectAttributes) {
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		Boolean status = resttemplate.getForEntity(Urls.getCountofVisa, Boolean.class, Map.of("userId", userId))
				.getBody();
		if (status) {
			redirectAttributes.addFlashAttribute("message", "No Visas Found");
			return "redirect:/Services";
		}
		VisaCancellation visa = new VisaCancellation();
		M.addAttribute("visa", visa);
		M.addAttribute("userId", userId);
		Passport passportId = resttemplate
				.getForEntity(Urls.getPassportObject, Passport.class, Map.of("userId", userId)).getBody();
		M.addAttribute("passportId", passportId.getPassportId());

		return "CancelVisa";
	}

	@RequestMapping("/CancelVisaForm")
	public String update(@Valid @ModelAttribute("visa") VisaCancellation visa, BindingResult bs,
			@RequestParam("visaId") String visaId, Model model, RedirectAttributes redirectAttributes,HttpSession session) {
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		if (bs.hasErrors()) {
			return "CancelVisa";
		}
		model.addAttribute("userId", userId);
		ResponseEntity<String> response = resttemplate.exchange(Urls.UpdateVisaStatus, HttpMethod.PUT, null,
				String.class, visaId);
		double cancellationCost = resttemplate.getForEntity(Urls.findVisaCancellationCost, Double.class, visaId)
				.getBody();
		redirectAttributes.addFlashAttribute("message",
				"Your Visa has been Cancelled Successfully!\n Cancellation charges: " + cancellationCost);

		return "redirect:/Services";
	}
}
