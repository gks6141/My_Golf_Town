package com.MyGolfTown.golf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/golf")
public class GolfController {

	@GetMapping("/main-view")
	public String mainView() {
		return "golf/mainView";
	}
}
