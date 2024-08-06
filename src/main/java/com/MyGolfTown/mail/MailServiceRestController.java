package com.MyGolfTown.mail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/mail")
public class MailServiceRestController {

    @Autowired
    RegisterMail registerMail;

    //127.0.0.1:8080/ROOT/api/mail/confirm.json?email
    @PostMapping("/confirm")
    public Map<String, Object> mailConfirm(@RequestParam("email") String email) throws Exception{
        String code = registerMail.sendSimpleMessage(email);
        
        Map<String, Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("result", "성공");
        return result;
    }
    
}
