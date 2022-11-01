package com.example.cinema.controller.userdetailcontroller;

import com.example.cinema.entity.userDetail.Role;
import com.example.cinema.entity.userDetail.User;
import com.example.cinema.security.CurrentUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserProfilePageController {

    @GetMapping("/user/profile")
    public String userProfilePage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            modelMap.addAttribute("user", user);
            if (user.getRole() == Role.USER) {
                return "main/userProfilePage";
            } else {
                return "admin/adminPage";
            }
        }
        return "redirect:/";
    }


}
