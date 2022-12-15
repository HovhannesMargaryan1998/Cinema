package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.dto.filmrequestdto.ActorRequestDTO;
import com.example.cinema.mapper.filmrequestmapper.ActorRequestMapper;
import com.example.cinema.service.ActorService;
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

@Controller
@RequiredArgsConstructor
public class ActorController {

    private final CheckImportedData checkImportedData;
    private final ActorService actorService;
    private final ActorRequestMapper actorRequestMapper;

    @PostMapping("/add/actor")
    public String addActor(@ModelAttribute @Valid ActorRequestDTO actorRequestDTO, BindingResult bindingResult,
                           @RequestParam("imageActor") MultipartFile multipartFile, ModelMap modelMap) {

        if (checkImportedData.checkData(bindingResult, multipartFile, modelMap).isPresent()) {
            checkImportedData.checkData(bindingResult, multipartFile, modelMap).get();
            return "admin/addActor";
        }
        actorService.addActor(actorRequestMapper.map(actorRequestDTO), multipartFile);
        return "admin/addActor";
    }


}
