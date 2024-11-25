package com.nhoclahola.bt_2511_springsecurityjwt_jwt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController
{
    @GetMapping("login")
    public String index()
    {
        return "login";
    }

    @GetMapping("user/profile")
    public String profile()
    {
        return "profile";
    }
}
