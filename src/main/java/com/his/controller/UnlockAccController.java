package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.his.dto.UnlockAcc;
import com.his.dto.User;
import com.his.service.UserService;
 

@Controller
public class UnlockAccController {
	
	@Autowired
	private UserService userService;
	
	 @GetMapping(value = "/unlockAcc")
	  public String displayUnlockAccForm(Model model) {
		 System.out.println("*************************");
		  //model.addAttribute("email",email);
		  UnlockAcc unlockAcc=new UnlockAcc();
		  model.addAttribute("unlockAcc",unlockAcc);
		  
		  return "unlockaccform";
		  
	  }
	 
	 @PostMapping(value = "/unlockUserAcc")
		public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockAcc unlockAcc, Model model) {
			System.out.println(unlockAcc);
		User user=	userService.updateTempPwdToNewPwd(unlockAcc);
		if(user!=null) {
			user.setAccstatus("UN-LOCK");
			user.setUserPazzword(unlockAcc.getConfirmPazzword());
			boolean isUpdate=userService.updateUserAcc(user);
			if(isUpdate) {
 				return "unlockaccAccSuccess";
			}
		}
		 
		model.addAttribute("error","Somting is worng!");
			
			 			return "unlockaccform";
		}

	

	 
	 @GetMapping(value = "/validPazzword")
	 @ResponseBody
	 public String validPazzword(@RequestParam("userEmail") String userEmail, @RequestParam("userPazzword") String userPazzword) {
		 return userService.validPazzword(userEmail, userPazzword);
	 }
  
}
