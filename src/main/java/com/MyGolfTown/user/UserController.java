package com.MyGolfTown.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyGolfTown.user.bo.UserBO;
import com.MyGolfTown.user.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Value("${kakao.client_id}")
	private String client_id;
	
	@Value("${kakao.redirect_uri}")
	private String redirect_uri;
	
	@GetMapping("/sign-in-view")
	public String signInView(Model model) {
		String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+client_id+"&redirect_uri="+redirect_uri;
        model.addAttribute("location", location);
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
