package com.MyGolfTown;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class testController {
	
	@ResponseBody
	@RequestMapping("/1")
	public String test() {
		return "성공";
	}
	
	@ResponseBody
	@RequestMapping("/2")
	public Map<String,Object> test1(){
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		return result;
	}
	
	@RequestMapping("/3")
	public String test2() {
		return "post/test";
	}
}
