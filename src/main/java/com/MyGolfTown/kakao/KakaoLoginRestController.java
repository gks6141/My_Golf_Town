package com.MyGolfTown.kakao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyGolfTown.kakao.bo.KakaoLoginBO;
import com.MyGolfTown.kakao.domain.KakaoUserInfoResponseDto;
import com.MyGolfTown.user.bo.UserBO;
import com.MyGolfTown.user.entity.UserEntity;

@Controller
@RequestMapping("/user")
public class KakaoLoginRestController {

	@Autowired
	private KakaoLoginBO kakaoLoginBO;
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/kakao-login")
	public String kakao(
			@RequestParam("code") String code,
			Model model){
		String accessToken = kakaoLoginBO.getAccessTokenFromKakao(code);
		KakaoUserInfoResponseDto userInfo = kakaoLoginBO.getUserInfo(accessToken);
		String userInfoId =String.valueOf(userInfo.getId());
		UserEntity user = userBO.getUserEntityByAuthId(userInfoId);
		if(user != null) {
			return "golf/mainView";
		}
		
		model.addAttribute("userInfo", userInfo);
		System.out.println(userInfo);
		return "user/signUp";
	}
}
