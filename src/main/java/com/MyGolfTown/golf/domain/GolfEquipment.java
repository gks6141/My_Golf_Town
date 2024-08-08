package com.MyGolfTown.golf.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class GolfEquipment {
	private int id;
	private String equipmentType;
	private String equipmentName;
	private String equipmentImagePath;
	private String equipmentSpecification;
	private int clubCount;
	private int equipmentPrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
