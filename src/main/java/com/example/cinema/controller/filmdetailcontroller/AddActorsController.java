package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.entity.filmDetail.Actor;
import com.example.cinema.service.actorservice.ActorService;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class AddActorsController {

    private final CreatePictureUtil createPictureUtil;

    private final ActorService actorService;

    @PostMapping("/add/actor")
    public String addActor(@ModelAttribute Actor actor, @RequestParam("imageActor") MultipartFile multipartFile,
                           ModelMap modelMap) {
        if (createPictureUtil.isPictureNotAllowedType(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/register";
        }
        actorService.addActor(actor, multipartFile);
        return "admin/addActor";
    }

}
