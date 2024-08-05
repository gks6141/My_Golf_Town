package com.MyGolfTown.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyGolfTown.user.bo.UserBO;
import com.MyGolfTown.user.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
	
	/**
	 * 로그인 API
	 * @param loginId
	 * @param password
	 * @return
	 */
	@PostMapping("/sign-in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpSession session){
		
		UserEntity user= userBO.getUserEntityByLoginIdPassword(loginId, password);
		Map<String, Object> result = new HashMap<>();

		if(user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 403);
			result.put("error_message", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
	
	/**
	 * 회원 가입 API
	 * @param loginId
	 * @param password
	 * @param name
	 * @param phoneNumber
	 * @param address
	 * @param email
	 * @return
	 */
	
	@PostMapping("/sign-up")
	public Map<String, Object> signUp (
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam("address") String address
			,@RequestParam("email") String email){		
		
		UserEntity user = userBO.addUserEntity(loginId, password, name, phoneNumber, address, email);
		
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 403);
			result.put("error_message", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
	
	
	/**
	 * 아이디 확인 API
	 * @param loginId
	 * @return
	 */
	@PostMapping("/is-duplication")
	public Map<String, Object> isDuplication(
			@RequestParam("loginId") String loginId){
		
		UserEntity user= userBO.getUserEntityByLoginId(loginId);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		if(user != null) {
			result.put("is_duplicated_id", true);
		} else {
			result.put("is_duplicated_id", false);
		}
		
		return result;
	}
	
}
