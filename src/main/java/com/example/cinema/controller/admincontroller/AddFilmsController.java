package com.example.cinema.controller.admincontroller;

import com.example.cinema.service.actorservice.ActorService;
import com.example.cinema.service.director.DirectorService;
import com.example.cinema.service.filmservice.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AddFilmsController {

    private final FilmService filmService;

    private final ActorService actorService;

    private final DirectorService directorService;

    @GetMapping("/add/actor")
    public String addActorPage() {
        return "/admin/addActor";
    }

    @GetMapping("/add/director")
    public String addDirectorPage() {
        return "/admin/addDirector";
    }

//    @PostMapping("/add/film")
//    public String addFilm(ModelMap modelMap) {
//
//
//    }
}
