package com.MyGolfTown.golf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyGolfTown.golf.bo.GolfClubBO;
import com.MyGolfTown.golf.domain.GolfClub;

@RestController
@RequestMapping("/golf")
public class GolfRestController {

	@Autowired
	private GolfClubBO golfClubBO;
	//채 중고, 새 제품
	@GetMapping("/club")
	public Map<String, Object> usedclub(
			@RequestParam("usedClub") boolean usedClub
			,@RequestParam("clubType") String clubType
			,Model model){
	
		List<GolfClub> club = golfClubBO.getGolfClubByUsedClubAndClubType(usedClub, clubType);
		
		Map<String, Object> result = new HashMap<>();
		if(club.size() >0 ) {	
			model.addAttribute("club", club);
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 403);
			result.put("error_message", "존재하지 않는 사용자입니다.");
		}
		return result;
	}
	
}
