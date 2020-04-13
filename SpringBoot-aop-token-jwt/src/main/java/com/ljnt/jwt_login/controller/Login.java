package com.ljnt.jwt_login.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljnt.jwt_login.entity.User;
import com.ljnt.jwt_login.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ Program       :  com.ljnt.jwt_login.controller.Login
 * @ Description   :  login控制类
 * @ Author        :  lj
 * @ CreateDate    :  2020-2-14 14:32
 */
@RestController
public class Login {

    @PostMapping("/login")
    @ResponseBody
    public String login(String username,String password,HttpServletRequest request,HttpServletResponse response) throws JsonProcessingException {
        //可以在此处检验用户密码
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        String token= TokenUtil.sign(user);
        HashMap<String,Object> hs=new HashMap<>();
        hs.put("token",token);
        ObjectMapper objectMapper=new ObjectMapper();
        response.setHeader("token", token);
        
        return objectMapper.writeValueAsString(hs);
    };
    @PostMapping("/index")
    @ResponseBody
    public String index(String username,String password,HttpServletRequest request) throws JsonProcessingException {
    	String header = request.getHeader("tiken");
    	System.out.println(header);
    	return "index";
    };
    
    
    
    
}