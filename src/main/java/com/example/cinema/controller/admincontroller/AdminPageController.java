package com.example.cinema.controller.admincontroller;

import com.example.cinema.service.actorservice.ActorService;
import com.example.cinema.service.director.DirectorService;
import com.example.cinema.service.filmservice.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AdminPageController {

    private final FilmService filmService;

    private final ActorService actorService;

    private final DirectorService directorService;

    @GetMapping("/admin/page")
    public String adminPage(){
        return "redirect:/user/profile";
    }

    @GetMapping("/add/film")
    public String addFilmsPage(ModelMap modelMap) {
        modelMap.addAttribute("directors", directorService.findAllDirectors());
        modelMap.addAttribute("actors", actorService.findAllActors());
        return "admin/addFilm";
    }

    @GetMapping("/catalog/films")
    public String CatalogFilmsPage() {
        return "admin/catalogFilms";
    }

    @GetMapping("/users/all")
    public String allUsersPage() {
        return "admin/allUsers";
    }

    @GetMapping("/all/comments/page")
    public String allCommentsPage() {
        return "admin/allComments";
    }

    @GetMapping("/edit/user")
    public String editUserPage() {
        return "admin/editUser";
    }




}
