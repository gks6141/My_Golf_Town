package com.MyGolfTown.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyGolfTown.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	
	public UserEntity findByLoginIdAndPassword(String loginId,String password) ;

	public UserEntity findByLoginId(String loginId);

	public UserEntity findByAuthId(String authId);
	
	public UserEntity findById(int Id);
}
