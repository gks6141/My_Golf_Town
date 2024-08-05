package com.MyGolfTown.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyGolfTown.user.entity.UserEntity;
import com.MyGolfTown.user.repository.UserRepository;

@Service
public class UserBO {
    
	@Autowired
	private UserRepository userRepository;
	
	public UserEntity getUserEntityByLoginIdPassword(String loginId,String password) {
		return userRepository.findByLoginIdAndPassword(loginId,password);
	}
	
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	public UserEntity addUserEntity(String loginId,
			String password, String name, String phoneNumber, String address, String email) {
		
		return userRepository.save(UserEntity.builder()
									.loginId(loginId)
									.password(password)
									.name(name)
									.phoneNumber(phoneNumber)
									.address(address)
									.email(email)
									.admin(false).build());
	}
}
