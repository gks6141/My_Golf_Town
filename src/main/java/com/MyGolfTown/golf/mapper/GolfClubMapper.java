package com.MyGolfTown.golf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.golf.domain.GolfClub;

@Mapper
public interface GolfClubMapper {

	public List<GolfClub> selectGolfClub();

	public GolfClub selectGolfClubById(int Id);
	
	public List<GolfClub> selectGolfClubByName(String Name);
	
	public List<GolfClub> selectGolfClubByUsedClubAndClubType(
			@Param("usedClub") boolean usedClub, 
			@Param("clubType") String clubType);
}
