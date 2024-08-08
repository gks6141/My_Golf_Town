package com.MyGolfTown.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailServiceRestController {

    @Autowired
    RegisterMail registerMail;

    
    @PostMapping("/confirm")
    public Map<String, Object> mailConfirm(
    		@RequestParam("email") String email) throws Exception{
    	
        String code = registerMail.sendSimpleMessage(email);
        
        Map<String, Object> result = new HashMap<>();
        
        
        result.put("code", 200);
        result.put("email_code", code);
        result.put("result", "성공");
        
        System.out.println(code);
        
        return result;
    }
    
}
