package com.example.cinema.controller.cinemadetailcontroller;

import com.example.cinema.mapper.cinemaresponsemapper.CinemaResponseMapper;
import com.example.cinema.mapper.cinemaresponsemapper.CinemaSeatResponseMapper;
import com.example.cinema.mapper.cinemaresponsemapper.TimeSinceResponseMapper;
import com.example.cinema.mapper.filmresponsemapper.FilmResponseMapper;
import com.example.cinema.mapper.userrequestmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
import com.example.cinema.service.CinemaSeatService;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class CinemaPageController {

    private final UserMapper userMapper;
    private final CinemaService cinemaService;
    private final FilmService filmService;
    private final FilmResponseMapper filmResponseMapper;
    private final TimeSinceResponseMapper timeSinceResponseMapper;
    private final CinemaResponseMapper cinemaResponseMapper;
    private final CinemaSeatResponseMapper cinemaSeatResponseMapper;
    private final CinemaSeatService cinemaSeatService;

    @GetMapping("/cinema/page/{id}")
    public String cinemaPage(@PathVariable("id") int id,
                             @AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {

        modelMap.addAttribute("cinema", cinemaResponseMapper.map(cinemaService.getCinemaById(id)));
        modelMap.addAttribute("user", userMapper.map(currentUser.getUser()));
        modelMap.addAttribute("films", filmResponseMapper.map(cinemaService.getCinemaById(id).getFilms()));
        return "cinema/cinemaPage";
    }

    @GetMapping("/get/choose/film/{id}/{cinemaId}")
    public String getChooseFilm(@PathVariable("id") int id, @PathVariable("cinemaId") int cinemaId, ModelMap modelMap,
                                @AuthenticationPrincipal CurrentUser currentUser) {

        modelMap.addAttribute("cinema", cinemaService.getCinemaById(cinemaId));
        modelMap.addAttribute("seats", cinemaSeatResponseMapper.map(cinemaSeatService.getSeatsByCinemaId(cinemaId)));
        modelMap.addAttribute("user", userMapper.map(currentUser.getUser()));
        modelMap.addAttribute("chooseFilm", filmResponseMapper.map(filmService.getFilmById(id)));
        modelMap.addAttribute("timeSinceChooseFilm",
                timeSinceResponseMapper.map(filmResponseMapper.map(filmService.getFilmById(id)).getTimes()));
        return "cinema/cinemaPageChooseFilm";
    }

}
