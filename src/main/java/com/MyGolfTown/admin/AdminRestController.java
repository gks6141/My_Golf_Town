package com.MyGolfTown.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MyGolfTown.admin.bo.AdminBO;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private AdminBO adminBO;
	
	@PostMapping("/insert-club")
	public Map<String, Object> insertClub(
			@RequestParam("usedClub") boolean usedClub,
			@RequestParam("clubType") String clubType,
			@RequestParam("clubName") String clubName,
			@RequestParam("file") MultipartFile file,
			@RequestParam("clubSpecification") String clubSpecification,
			@RequestParam("clubCount") int clubCount,
			@RequestParam("clubPrice") int clubPrice){
		
		
		
		adminBO.addGolfClub(usedClub, clubType, clubName, file, clubSpecification, clubCount, clubPrice);
		
		Map<String,Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");			
		
		return result;
	}
	
	@PostMapping("/insert-equipment")
	public Map<String, Object> insertEquipment(
			@RequestParam("equipmentType") String equipmentType,
			@RequestParam("equipmentName") String equipmentName,
			@RequestParam("file") MultipartFile file,
			@RequestParam("equipmentSpecification") String equipmentSpecification,
			@RequestParam("equipmentCount") int equipmentCount,
			@RequestParam("equipmentPrice") int equipmentPrice){
		
		
		
		adminBO.addGolfEquipment(equipmentType, equipmentName, file, equipmentSpecification, equipmentCount, equipmentPrice);
		
		Map<String,Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");			
		
		return result;
	}
}
