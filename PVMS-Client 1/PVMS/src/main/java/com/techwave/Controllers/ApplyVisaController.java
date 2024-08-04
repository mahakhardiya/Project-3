package com.techwave.Controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techwave.Urls;
import com.techwave.Models.Pojos.Passport;
import com.techwave.Models.Pojos.Visa;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes({ "userIdSession" })
public class ApplyVisaController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/ApplyVisa")
	public String insertVisa(Model M,RedirectAttributes redirectAttributes,HttpSession session)
	{
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		try
		{
		String checkPassport=restTemplate.getForEntity(Urls.checkExpiryDate,String.class,Map.of("userId",userId)).getBody();
		if(checkPassport.contains("issued")){
			redirectAttributes.addFlashAttribute("message", checkPassport);
			return "redirect:/Services";
		}
		Visa visa =new Visa();
		M.addAttribute("visa", visa);
		M.addAttribute("dateOfApplication",LocalDate.now());
		M.getAttribute(userId);
		ResponseEntity<Passport> passportObject=restTemplate.getForEntity(Urls.getPassportObject, Passport.class, Map.of("userId",userId));
		M.addAttribute("passportId", passportObject.getBody().getPassportId());
		return "insertVisa";
		}
		catch(Exception E)
		{
			redirectAttributes.addFlashAttribute("PassportError", "Please Apply Passport Before Applying for Visa");
			return "redirect:/Services";
		}
	}

	@RequestMapping("/VisaForm")
	public String insertVisa1(@Valid @ModelAttribute("visa") Visa visa,BindingResult bs,HttpSession session,Model M,RedirectAttributes redirectAttributes)
	{	
		M.addAttribute("dateOfApplication",LocalDate.now());
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
		    ResponseEntity<Passport> passportObject=restTemplate.getForEntity(Urls.getPassportObject, Passport.class, Map.of("userId",userId));
		    M.addAttribute("passportId", passportObject.getBody().getPassportId());
		
		if(bs.hasErrors())
		{
			return "insertVisa";
		}
		else
		{
				
				ResponseEntity<Integer> visapermit=restTemplate.getForEntity(Urls.getVisaPermit, Integer.class, Map.of("occupation",visa.getOccupation()));
				
				LocalDate visaExpiry=LocalDate.now().plusYears(visapermit.getBody());
				LocalDate passportExpiry=passportObject.getBody().getExpiryDate();
 
				long daysBetween1 = ChronoUnit.DAYS.between(LocalDate.now(),passportExpiry);
 
				if (daysBetween1 <=0) {
					String str="Passport is expiring soon";
				    str=str+"\nPlease Renew your Passport";
				    redirectAttributes.addFlashAttribute("message",str);
				    return "redirect:/Services";
				} else if (passportExpiry.isBefore(visaExpiry)) {
					visa.setUserId(M.getAttribute("userIdSession").toString());
					visa.setPassportId(passportObject.getBody());
					visa.setExpiryDate(passportExpiry);
					visa.setDateOfApplication(LocalDate.now());
					ResponseEntity<Visa> visaObject=restTemplate.postForEntity(Urls.insertVisa, visa, Visa.class);
					
					//Adding to List
					List<String> list=new ArrayList<String>();
					list.add("You have Successfully Applied for Visa .... ! ");
					list.add("Visa Id :"+visaObject.getBody().getVisaId());
					list.add("Date Of Issue :"+visaObject.getBody().getIssueDate());
					list.add("Date Of Expiry :"+visaObject.getBody().getExpiryDate());
					list.add("Cost :"+visaObject.getBody().getRegistrationCost());
					redirectAttributes.addFlashAttribute("visaDetails",list);
					return "redirect:/Services";
				} else {
					visa.setUserId(M.getAttribute("userIdSession").toString());
					visa.setPassportId(passportObject.getBody());
					visa.setExpiryDate(visaExpiry);
					visa.setDateOfApplication(LocalDate.now());
					ResponseEntity<Visa> visaObject=restTemplate.postForEntity(Urls.insertVisa, visa, Visa.class);
					
					//Adding to List
					List<String> list=new ArrayList<String>();
					list.add("You have Successfully Applied for Visa .... ! ");
					list.add("Visa Id :"+visaObject.getBody().getVisaId());
					list.add("Date Of Issue :"+visaObject.getBody().getIssueDate());
					list.add("Date Of Expiry :"+visaObject.getBody().getExpiryDate());
					list.add("Cost :"+visaObject.getBody().getRegistrationCost());
					redirectAttributes.addFlashAttribute("visaDetails",list);
					return "redirect:/Services";
				}
				
				
		}
	}
	
	@RequestMapping("/ShowVisa")
	public String showvisa(Model M,HttpSession session)
	{
		 String userId = (String) session.getAttribute("userIdSession");
		    if (userId == null) {
		        return "redirect:/";
		    }
			M.getAttribute("userIdSession").toString();
			return "ShowVisa";
	}
}
