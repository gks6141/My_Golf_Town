package com.MyGolfTown.golf.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.golf.domain.GolfEquipment;
import com.MyGolfTown.golf.mapper.GolfEquipmentMapper;

@Service
public class GolfEquipmentBO {

	@Autowired
	private GolfEquipmentMapper golfEquipmentMapper;
	
	public List<GolfEquipment> getGolfEquipment(){
		return golfEquipmentMapper.selectGolfEquipment();
	}
	
	public GolfEquipment getGolfEquipmentById(int Id){
		return golfEquipmentMapper.selectGolfEquipmentById(Id);
	}
	
	public List<GolfEquipment> getGolfEquipmentByName(String Name){
		return golfEquipmentMapper.selectGolfEquipmentByName(Name);
	}
}
