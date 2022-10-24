package com.example.cinema.controller.userdetailcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/forgot/password")
    public String forgotPassword() {
        return "main/forgot";
    }

    @GetMapping("/user/login")
    public String LoginPage() {
        return "main/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "main/register";
    }
}
