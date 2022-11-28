package com.example.cinema.controller.filmdetailcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FilmController {

    @GetMapping("/watch/film")
    public String singleFilmPage() {
        return "main/watchFilmPage";
    }

    @GetMapping("/films")
    public String allFilmsPage(){
        return "main/allFilmsPage";
    }


}
