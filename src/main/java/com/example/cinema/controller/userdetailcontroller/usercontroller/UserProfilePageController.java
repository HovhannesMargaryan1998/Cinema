package com.example.cinema.controller.userdetailcontroller.usercontroller;


import com.example.cinema.dto.userresponsedetaildto.UserResponseDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.mapper.userrequestdetailmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class UserProfilePageController {

    private final UserMapper userMapper;
    private final UserService userService;
    private final FilmService filmService;

    @GetMapping("/user/profile")
    public String userProfilePage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {
        if (currentUser != null) {
            UserResponseDTO userResponse = userMapper.map(currentUser.getUser());
            modelMap.addAttribute("user", userResponse);
            modelMap.addAttribute("countFilms", filmService.getCountAllFilms());
            modelMap.addAttribute("countUsers", userService.getCountAllUsers());
            modelMap.addAttribute("topFiveFilmsByRating", filmService.getFiveFilmsByRating());
            modelMap.addAttribute("lastFiveUsers", userService.getLastFiveUsers());
            if (userResponse.getRole() == Role.USER) {
                return "main/userProfilePage";
            } else {
                return "admin/adminPage";
            }
        }
        return "redirect:/";
    }


}
