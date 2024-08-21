package com.MyGolfTown.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.common.SHA256;
import com.MyGolfTown.user.entity.UserEntity;
import com.MyGolfTown.user.repository.UserRepository;

@Service
public class UserBO {
    
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUserEntityByLoginIdPassword(String loginId,String password) {
		password = SHA256.encode(password);
		return userRepository.findByLoginIdAndPassword(loginId,password);
	}
	
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	public UserEntity getUserEntityByAuthId(String authId) {
		return userRepository.findByAuthId(authId);
	}
	
	public UserEntity addUserEntity(String loginId,
			String password, String name, String phoneNumber, String address, String email, String authId) {
		
		password = SHA256.encode(password);
		
		return userRepository.save(UserEntity.builder()
									.loginId(loginId)
									.password(password)
									.name(name)
									.phoneNumber(phoneNumber)
									.address(address)
									.email(email)
									.authId(authId)
									.admin(false).build());
	}
	
	public UserEntity getUserEntityByUserId(int Id) {
		return userRepository.findById(Id);
	}
}
