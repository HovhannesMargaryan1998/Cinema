package com.example.cinema.controller.filmdetailcontroller;

import com.example.cinema.entity.filmDetail.Director;
import com.example.cinema.service.DirectorService;
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
public class AddDirectorsController {

    private final CreatePictureUtil createPictureUtil;

    private final DirectorService directorService;

    @PostMapping("/add/director")
    public String addActor(@ModelAttribute Director director, @RequestParam("imageDirector") MultipartFile multipartFile,
                           ModelMap modelMap) {
        if (createPictureUtil.isPictureNotAllowedType(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/register";
        }
        directorService.addDirector(director, multipartFile);
        return "admin/addActor";
    }

}
