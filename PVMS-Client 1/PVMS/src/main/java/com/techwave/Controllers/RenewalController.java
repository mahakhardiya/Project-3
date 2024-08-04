package com.techwave.Controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techwave.Urls;
import com.techwave.Models.Pojos.RenewalOfPassport;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({"userIdSession" })
public class RenewalController {
	
	@Autowired
	RestTemplate restTemplate;
	
	 @RequestMapping("/Services")
	    public String services(Model model, HttpSession session) {
	        String userId = (String) session.getAttribute("userIdSession");
	        if (userId == null) {
	            return "redirect:/";
	        }
	        model.addAttribute("userId", userId);
	        return "Services";
	    }

	
	@RequestMapping("/PassportRenewal")
	public String checkDetails(RedirectAttributes redirectAttributes,Model model,HttpSession session) {
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		String message=restTemplate.getForEntity(Urls.checkExpiryDate,String.class,Map.of("userId",userId)).getBody();
		if(message==null){
			RenewalOfPassport renewal=new RenewalOfPassport();
			model.addAttribute("PassportRenewal", renewal);
			model.addAttribute("userId", userId);
			return "RenewalForm";
		}
		else if(message.contains("Expired")) {
			redirectAttributes.addFlashAttribute("message",message);
			return "redirect:/Services";
		}
		else{
			redirectAttributes.addFlashAttribute("message",message);
			return "redirect:/Services";
		}
	}
	
	@RequestMapping("/RenewPassport")
	public String passportRenewalForm(@Valid @ModelAttribute("PassportRenewal") RenewalOfPassport PassportRenewal, BindingResult bs,RedirectAttributes redirectAttributes,HttpSession session,Model model) {
		 String userId = (String) session.getAttribute("userIdSession");
		 model.addAttribute("userId", userId);
		    if (userId == null) {
		        return "redirect:/";
		    }
		try {
	        if (bs.hasErrors()) {
	            return "RenewalForm";
	        }  
	        PassportRenewal.setUserId(userId);
	        ResponseEntity<String> newPassportDetails=restTemplate.exchange(Urls.reissuePassport, HttpMethod.PUT,new HttpEntity<RenewalOfPassport>(PassportRenewal), String.class);
	        redirectAttributes.addFlashAttribute("message", newPassportDetails.getBody());
	        return "redirect:/Services";
	    } catch (HttpClientErrorException e) {
	        return "RenewalForm";
	    }
	}

	
}
