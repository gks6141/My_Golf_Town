package com.MyGolfTown.golf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.MyGolfTown.golf.domain.GolfEquipment;

@Mapper
public interface GolfEquipmentMapper {

	public List<GolfEquipment> selectGolfEquipment();
	
	public GolfEquipment selectGolfEquipmentById(int Id);
}
