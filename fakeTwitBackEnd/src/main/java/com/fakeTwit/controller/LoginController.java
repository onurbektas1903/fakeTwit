package com.fakeTwit.controller;

import com.fakeTwit.entity.User;
import com.fakeTwit.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    LoginService loginService;
    @Autowired
    public void setLoginService(LoginService loginService){
        this.loginService =loginService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String fakeLogin(@RequestBody User user) {
            return loginService.fakeLogin(user);
    }
}
