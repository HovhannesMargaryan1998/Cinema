package com.example.cinema.controller.admincontroller;

import com.example.cinema.dto.FilmRequestDTO;
import com.example.cinema.entity.filmDetail.Film;
import com.example.cinema.service.ActorService;
import com.example.cinema.service.DirectorService;
import com.example.cinema.service.FilmService;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class AddFilmsController {

    private final FilmService filmService;

    private final CreatePictureUtil createPictureUtil;

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


    @PostMapping("/add/film")
    public String addActor(@ModelAttribute FilmRequestDTO filmRequestDTO, @RequestParam("imageFilm") MultipartFile multipartFile,
                           ModelMap modelMap) {
        if (createPictureUtil.isPictureNotAllowedType(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/register";
        }
        filmService.addFilm(filmRequestDTO, multipartFile);
        return "admin/addActor";
    }
}
