package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.his.dto.User;
import com.his.service.UserService;

@Controller
public class GetUserDtlsController {
	
	@Autowired
	private UserService userServic;
	
	@PostMapping("/editform")
	public String editUser(@RequestParam("userId") Integer userId, Model model) {
		User user=userServic.getUserByID(userId);
		model.addAttribute("user", user);
		return "rejester";
	}
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public  List<User> getUsersByRoleId(@RequestParam("roleId") Integer roleId) {
		return userServic.getUsersByRoleId(roleId);
	}
	
	@DeleteMapping("/userDelete")
	boolean userDeleted(User user) {
		return userServic.userDelete(user);
	}
	

}
