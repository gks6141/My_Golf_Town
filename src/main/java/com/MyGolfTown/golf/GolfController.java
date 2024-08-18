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
	
	@GetMapping("/driver-view")
	public String driverView() {
		return "golf/driverView";
	}
	
	
	@GetMapping("/iron-view")
	public String ironView() {
		return "golf/ironView";
	}
	
	@GetMapping("/util-woodView-view")
	public String utilWoodView() {
		return "golf/utilWoodView";
	}
	
	@GetMapping("/wedge-view")
	public String wedgeView() {
		return "golf/wedgeView";
	}
	
	@GetMapping("/putter-view")
	public String putterView() {
		return "golf/putterView";
	}
	
	@GetMapping("/women-club-view")
	public String womenClubView() {
		return "golf/womenClubView";
	}
	
	@GetMapping("/fullset-view")
	public String fullsetView() {
		return "golf/fullsetView";
	}
	
	@GetMapping("/shaft-view")
	public String shaftView() {
		return "golf/shaftView";
	}
	
	
}
