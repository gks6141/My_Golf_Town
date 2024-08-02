package com.MyGolfTown.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.MyGolfTown.user.domain.User;

@Mapper
public interface UserMapper {

	public User selectUser();
}
