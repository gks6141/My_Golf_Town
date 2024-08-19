package com.MyGolfTown.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.bo.GolfEquipmentBO;
import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.golf.domain.GolfEquipment;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private GolfEquipmentBO golfEquipmentBO;

	@Autowired
	private GolfClubBO golfClubBO;
	
	@GetMapping("/club-insert-view")
	public String clubInsertView() {
		return "admin/insertClub";
	}
	
	@GetMapping("/equipment-insert-view")
	public String equipmentInsertView() {
		return "admin/insertEquipment";
	}
	
	@GetMapping("/product-create-view")
	public String productCreateView(Model model) {
		
		List<GolfClub> club = golfClubBO.getGolfClub();
		List<GolfEquipment> equipment = golfEquipmentBO.getGolfEquipment();
		
		model.addAttribute("golfClubs", club);
		model.addAttribute("golfEquipments", equipment);
		
		return "admin/productCreateView";
	}
	
}
