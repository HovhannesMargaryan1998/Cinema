package com.example.cinema.controller.cinemadetailcontroller;

import com.example.cinema.mapper.cinemaresponsemapper.CinemaResponseMapper;
import com.example.cinema.mapper.filmresponsemapper.FilmResponseMapper;
import com.example.cinema.mapper.userrequestmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
import com.example.cinema.service.CinemaService;
import com.example.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CinemaPageController {

    private final UserMapper userMapper;
    private final CinemaService cinemaService;
    private final FilmService filmService;
    private final FilmResponseMapper filmResponseMapper;

    @GetMapping("/cinema/page{id}")
    public String cinemaPage(@PathVariable("id") int id,
                             @AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap){
        modelMap.addAttribute("user", userMapper.map(currentUser.getUser()));
        modelMap.addAttribute("films", cinemaService.getCinemaById(id).getFilms());
        return "cinema/cinemaPage";
    }

    @GetMapping("/order/ticket{id}")
    public String orderTicketPage(@PathVariable("id") int id,
                                  @AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap){
        modelMap.addAttribute("user", userMapper.map(currentUser.getUser()));
        modelMap.addAttribute("films", cinemaService.getCinemaById(id).getFilms());
        return "cinema/orderTicket";
    }

    @GetMapping("/get/choose/film/{id}")
    public String getChooseFilm(@PathVariable("id") int id, ModelMap modelMap){
        modelMap.addAttribute("chooseFilm", filmResponseMapper.map(filmService.getFilmById(id)));
        return "cinema/cinemaPage";
    }


}
