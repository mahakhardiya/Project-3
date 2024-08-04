package com.techwave.Controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.techwave.Urls;
import com.techwave.Models.Pojos.Passport;
import com.techwave.Models.Pojos.UsersRegistrations;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes({ "userIdSession","passportId"})
public class ProfileController {
	
	@Autowired
	RestTemplate resttemplate;
	
	@RequestMapping("/Profile")
	public String  getUserDetails(HttpSession session,Model M){
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		ResponseEntity<UsersRegistrations> userDetails=resttemplate.getForEntity(Urls.getUserById, UsersRegistrations.class,Map.of("id",userId));
		M.addAttribute("user", userDetails.getBody());
		return "Profile";
	}
	
	@RequestMapping("/ShowPassport")
	public String showPassport(Model M,HttpSession session) {
		String userId = (String) session.getAttribute("userIdSession");
	    if (userId == null) {
	        return "redirect:/";
	    }
		ResponseEntity<UsersRegistrations> userDetails=resttemplate.getForEntity(Urls.getUserById, UsersRegistrations.class,Map.of("id",userId));
		
		String message=resttemplate.getForEntity(Urls.checkExpiryDate,String.class,Map.of("userId",userId)).getBody();
		if(message==null ||message.contains("Expired") ) {
			Passport passport = resttemplate
					.getForEntity(Urls.getPassportObject, Passport.class, Map.of("userId", userId)).getBody();
			
			M.addAttribute("user", userDetails.getBody());
			M.addAttribute("passport", passport);
			
			return "Passport";
		}
		else{
			M.addAttribute("user", userDetails.getBody());
			M.addAttribute("message",message);
			return "Profile";
			
		}
		
	}	
	
}
