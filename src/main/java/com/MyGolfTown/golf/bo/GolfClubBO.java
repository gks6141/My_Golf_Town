package com.MyGolfTown.golf.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.golf.domain.GolfClub;
import com.MyGolfTown.golf.mapper.GolfClubMapper;

@Service
public class GolfClubBO {
	
	@Autowired
	private GolfClubMapper golfClubMapper;

	public List<GolfClub> getGolfClub(){
		return golfClubMapper.selectGolfClub();
	}
	
	public List<GolfClub> getGolfClubByUsedClubAndClubType(boolean usedClub, String clubType){
		return golfClubMapper.selectGolfClubByUsedClubAndClubType(usedClub, clubType);
	}
	
	public GolfClub getGolfClubById(int Id){
		return golfClubMapper.selectGolfClubById(Id);
	}

}
