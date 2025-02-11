package com.MyGolfTown.admin.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MyGolfTown.admin.mapper.AdminMapper;
import com.MyGolfTown.common.FileManagerService;

@Service
public class AdminBO {

	@Autowired
	private FileManagerService fileManagerService;
	
	@Autowired
	private AdminMapper adminMapper;
	
	public void addGolfClub(boolean usedClub, String clubType, String clubName, MultipartFile file, String clubSpecification, int clubCount, int clubPrice) {
		
		String imagePath = null;
		
		
		imagePath =  fileManagerService.uploadFile(file, clubName);
		adminMapper.insertGolfClub(usedClub, clubType, clubName, imagePath, clubSpecification, clubCount, clubPrice);
	}
	
	public void addGolfEquipment(String equipmentType, String equipmentName, MultipartFile file, String equipmentSpecification, int equipmentCount, int equipmentPrice) {
		
		String imagePath = null;
		
		
		imagePath =  fileManagerService.uploadFile(file, equipmentName);
		adminMapper.insertGolfEquipment(equipmentType, equipmentName, imagePath, equipmentSpecification, equipmentCount, equipmentPrice);
	}
	
	public void addProduct(Integer clubId, Integer equipmentId, String productSubject, String productInformationText, MultipartFile file) {
		
		String imagePath = null;
		
		
		imagePath =  fileManagerService.uploadFile(file, productSubject);
		adminMapper.insertProduct(clubId, equipmentId, productSubject, productInformationText, imagePath);
	}
	
}
