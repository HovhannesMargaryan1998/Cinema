package com.example.cinema.controller.cinemadetailcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CinemaPageController {

    @GetMapping("/cinema")
    public String cinemaPage(){
        return "cinema/cinemaPage";
    }
}
