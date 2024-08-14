package com.MyGolfTown.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyGolfTown.user.bo.UserBO;
import com.MyGolfTown.user.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/sign-in-view")
	public String signInView() {
		return "user/signIn";
	}
	
	@GetMapping("/sign-up-view")
	public String signUpView() {
		return "user/signUp";
	}
	
	@GetMapping("/sign-out")
	public String signOut(HttpSession session) {
		
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		return "golf/mainView";
	}
	
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/update-view")
	public String updateView(HttpSession session,Model model) {
		UserEntity user = userBO.getUserEntityByUserId((Integer)session.getAttribute("userId"));
		
		model.addAttribute("user",user);
		
		return "user/updateView";
	}
	
}
