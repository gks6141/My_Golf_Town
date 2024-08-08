package com.MyGolfTown.golf.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class GolfClub {

	private int id;
	private boolean usedClub;
	private String clubType;
	private String clubName;
	private String clubImagePath;
	private String clubSpecification;
	private int clubCount;
	private int clubPrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
