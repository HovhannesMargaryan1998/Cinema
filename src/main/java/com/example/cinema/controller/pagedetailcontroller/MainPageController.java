package com.example.cinema.controller.pagedetailcontroller;

import com.example.cinema.entity.filmdetail.Film;
import com.example.cinema.mapper.filmresponsedetailmapper.FilmResponseMapper;
import com.example.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

     private final FilmService filmService;
     private final FilmResponseMapper filmResponseMapper;

    @GetMapping("/")
    public String mainPage(ModelMap map) {
        map.addAttribute("films", filmResponseMapper.map(filmService.getLastFilms()));
        return "main/mainHome";
    }

    @GetMapping("/home")
    public String homePage(ModelMap map) {
        map.addAttribute("films", filmResponseMapper.map(filmService.getLastFilms()));
        return "main/mainHome";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "main/about";
    }

}
