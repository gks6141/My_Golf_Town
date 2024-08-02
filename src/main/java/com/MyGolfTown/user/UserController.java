package com.MyGolfTown.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyGolfTown.user.bo.UserBO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/sign-in-view")
	public String signInView(Model model) {
		model.addAttribute("result", userBO.getUser());
		return "post/test";
	}
	
}
