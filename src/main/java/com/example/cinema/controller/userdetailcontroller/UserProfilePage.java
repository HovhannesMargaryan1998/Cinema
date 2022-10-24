package com.example.cinema.controller.userdetailcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserProfilePage {

    @GetMapping("/user/profile")
    public String userProfilePage() {
        return "main/userProfilePage";
    }

}
