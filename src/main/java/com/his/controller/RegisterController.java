package com.his.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.his.dto.User;
import com.his.service.RoleService;
import com.his.service.UserService;


@Controller
public class RegisterController {
	
	@Autowired
	private UserService userServic;
	@Autowired
	private RoleService roleService;
	
	 @GetMapping(value = {"/","/getfrom"})
		public String regesterForm(Model model) {
			 User user=new User();
			 model.addAttribute("user",user);
			 Map<Integer,String> roles=roleService.getAllRoles();
			 
			 model.addAttribute("roles",roles);
			return "rejester";
		}
	  
	 @GetMapping("/validateEmail")
	 @ResponseBody
	 public String validEmail(@RequestParam("userEmail") String userEmail) {
		 return userServic.validEmail(userEmail);
		 
	 }
	 
	 @PostMapping(value="/userAccReg")
	 public String saveUser(@ModelAttribute("user") User user){
		 userServic.saveUserDtls(user);
		return "usersccs";
	 }
}
