package com.example.cinema.controller.pagedetailcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String mainPage() {
        return "main/mainHome";
    }

    @GetMapping("/home")
    public String homePage() {
        return "main/mainHome";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "main/about";
    }



}
