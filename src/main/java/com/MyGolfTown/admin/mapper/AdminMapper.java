package com.MyGolfTown.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {

	public void insertGolfClub(
			@Param("usedClub") boolean usedClub,
			@Param("clubType") String clubType,
			@Param("clubName") String clubName,
			@Param("imagePath") String imagePath,
			@Param("clubSpecification") String clubSpecification,
			@Param("clubCount") int clubCount,
			@Param("clubPrice") int clubPrice);
	
	public void insertGolfEquipment(
			@Param("equipmentType") String equipmentType,
			@Param("equipmentName") String equipmentName,
			@Param("imagePath") String imagePath,
			@Param("equipmentSpecification") String equipmentSpecification,
			@Param("equipmentCount") int equipmentCount,
			@Param("equipmentPrice") int equipmentPrice);
	
	
	public void insertProduct(
			@Param("clubId") Integer clubId,
			@Param("equipmentId") Integer equipmentId, 
			@Param("productSubject") String productSubject, 
			@Param("productInformationText") String productInformationText, 
			@Param("imagePath") String imagePath);
}
