package com.example.cinema.controller.cinemadetailcontroller;

import com.example.cinema.dto.cinemarequestdto.CinemaRequestDTO;
import com.example.cinema.mapper.cinemarequestmapper.CinemaRequestMapper;
import com.example.cinema.service.CinemaService;
import com.example.cinema.util.CheckImportedData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class CinemaController {

    private final CheckImportedData checkImportedData;
    private final CinemaService cinemaService;
    private final CinemaRequestMapper cinemaRequestMapper;

    @PostMapping("/add/cinema")
    public String addCinema(@ModelAttribute @Valid CinemaRequestDTO cinemaRequestDTO, BindingResult bindingResult,
                            @RequestParam("imageCinema")MultipartFile multipartFile, ModelMap modelMap){
        if (checkImportedData.checkDataAndEmail(bindingResult, cinemaRequestDTO.getEmail(), multipartFile, modelMap).isPresent()){
            checkImportedData.checkDataAndEmail(bindingResult, cinemaRequestDTO.getEmail(), multipartFile, modelMap);
            return "admin/addCinema";
        }
        cinemaService.addCinema(cinemaRequestMapper.map(cinemaRequestDTO), multipartFile);
        return "admin/addCinema";
    }

    @PostMapping("/add/films-in/cinema")
    public String addFilmsInCinema(@RequestParam("cinemaId") int cinemaId,
                                   @RequestParam("filmsId") List<Integer> filmsId){
        cinemaService.addFilmsInCinema(cinemaId, filmsId);
        return "admin/addFilmInCinema";
    }

}
