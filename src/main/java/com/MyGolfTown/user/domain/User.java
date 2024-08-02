package com.MyGolfTown.user.domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class User {
	private int id;
	private String loginId;
	private String password;
	private String name;
	private String phoneNumber;
	private String address;
	private String email;
	private boolean admin;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
