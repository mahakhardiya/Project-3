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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techwave.Urls;
import com.techwave.Models.Pojos.PassportLost;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PassportLostController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/PassportLost")
	public String passportLost(HttpSession session,Model model,RedirectAttributes redirectAttributes) {
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		String message=restTemplate.getForEntity(Urls.checkExpiryDate,String.class,Map.of("userId",userId)).getBody();
		if(message==null||message.contains("Expired")){
			PassportLost passportLost=new PassportLost();
			model.addAttribute("passportLost", passportLost);
			model.addAttribute("userId", userId);
			return "PassportLost";
		}
		else {
			redirectAttributes.addFlashAttribute("message",message);
			return "redirect:/Services";
		}
	}
	
	
	@RequestMapping("/ValidatePassportLost")
	public String passportLost(@Valid @ModelAttribute("passportLost") PassportLost passportLost,BindingResult bs,Model model,RedirectAttributes redirectAttributes,HttpSession session) {
		 String userId = (String) session.getAttribute("userIdSession");
		 model.addAttribute("userId", userId);
		    if (userId == null) {
		        return "redirect:/";
		    }
		    
		    try {
		        if (bs.hasErrors()) {
		        	System.out.println("error");
		            return "PassportLost";
		        }  
		        passportLost.setUserId(userId);
		        ResponseEntity<String> newPassportDetails=restTemplate.exchange(Urls.lostPassport, HttpMethod.PUT,new HttpEntity<PassportLost>(passportLost), String.class);
		        redirectAttributes.addFlashAttribute("message", newPassportDetails.getBody());
		        return "redirect:/Services";
		    } catch (HttpClientErrorException e) {
		        return "PassportLost";
		    }
		
	}
	
}
