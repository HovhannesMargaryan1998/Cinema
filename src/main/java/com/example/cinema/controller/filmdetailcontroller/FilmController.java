package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/watch/film")
    public String singleFilmPage(ModelMap modelMap) {

        return "main/watchFilmPage";
    }

    @GetMapping("/films")
    public String allFilmsPage(){
        return "main/allFilmsPage";
    }

}
