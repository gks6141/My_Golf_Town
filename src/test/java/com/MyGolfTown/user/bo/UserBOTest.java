package com.MyGolfTown.user.bo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserBOTest {
	@Autowired
	UserBO userBO;
	
	@Transactional
	@Test
	void 회원가입() {
		userBO.addUserEntity("test1", "test2", "test3", "test4", "test5", "test6");
	}

}
