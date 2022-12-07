package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.dto.filmrequestdetaildto.FilmRequestDTO;
import com.example.cinema.service.ActorService;
import com.example.cinema.service.DirectorService;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.GenreService;
import com.example.cinema.util.CheckImportedData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AddFilmsController {
    private final GenreService genreService;
    private final ActorService actorService;
    private final DirectorService directorService;
    private final CheckImportedData checkImportedData;
    private final FilmService filmService;

    @GetMapping("/add/actor")
    public String addActorPage() {
        return "/admin/addActor";
    }

    @GetMapping("/add/director")
    public String addDirectorPage() {
        return "/admin/addDirector";
    }

    @PostMapping("/add/film")
    public String addFilm(@ModelAttribute @Valid FilmRequestDTO filmRequestDTO, BindingResult bindingResult,
                              @RequestParam("imageFilm") MultipartFile multipartFile, ModelMap modelMap) {
        if (checkImportedData.checkData(bindingResult, multipartFile, modelMap).isPresent()){
            checkImportedData.checkData(bindingResult, multipartFile, modelMap).get();
            modelMap.addAttribute("directors", directorService.findAllDirectors());
            modelMap.addAttribute("actors", actorService.findAllActors());
            modelMap.addAttribute("genres", genreService.findAllGenres());
            return "admin/addFilm";
        }
        filmService.addFilm(filmRequestDTO, multipartFile);
        return "redirect:/add/film";
    }
}
