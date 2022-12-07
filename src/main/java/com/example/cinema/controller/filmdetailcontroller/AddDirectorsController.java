package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.dto.filmrequestdetaildto.ActorRequestDTO;
import com.example.cinema.dto.filmrequestdetaildto.DirectorRequestDTO;
import com.example.cinema.entity.filmdetail.Director;
import com.example.cinema.service.DirectorService;
import com.example.cinema.util.CheckImportedData;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AddDirectorsController {

    private final CheckImportedData checkImportedData;

    private final DirectorService directorService;

    @PostMapping("/add/director")
    public String addDirector(@ModelAttribute @Valid DirectorRequestDTO directorRequestDTO, BindingResult bindingResult,
                           @RequestParam("imageDirector") MultipartFile multipartFile, ModelMap modelMap) {
        if (checkImportedData.checkData(bindingResult, multipartFile, modelMap).isPresent()){
            checkImportedData.checkData(bindingResult, multipartFile, modelMap).get();
            return "admin/addDirector";
        }
        directorService.addDirector(directorRequestDTO, multipartFile);
        return "admin/addDirector";
    }

}
