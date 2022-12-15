package com.example.cinema.controller.pagedetailcontroller;

import com.example.cinema.mapper.cinemaresponsemapper.CinemaResponseMapper;
import com.example.cinema.mapper.filmresponsemapper.FilmResponseMapper;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final FilmService filmService;
    private final FilmResponseMapper filmResponseMapper;
    private final CinemaResponseMapper cinemaResponseMapper;
    private final CinemaService cinemaService;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap) {
        modelMap.addAttribute("films", filmResponseMapper.map(filmService.getLastFilms()));
        modelMap.addAttribute("cinemas", cinemaResponseMapper.map(cinemaService.getAllCinemas()));
        return "main/mainHome";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "main/about";
    }

}
