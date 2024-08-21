package com.MyGolfTown.golf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.MyGolfTown.golf.domain.GolfEquipment;

@Mapper
public interface GolfEquipmentMapper {

	public List<GolfEquipment> selectGolfEquipment();
	
	public GolfEquipment selectGolfEquipmentById(int Id);
	
	public GolfEquipment selectGolfEquipmentByIdEquipmentType(
			@Param("id") int Id,
			@Param("equipmentType") String equipmentType);
	
	public List<GolfEquipment> selectGolfEquipmentByName(String Name);
}
