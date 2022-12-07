package com.example.cinema.controller.userdetailcontroller.usercontroller;

import com.example.cinema.dto.userresponsedetaildto.UserResponseDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.entity.userdetail.User;
import com.example.cinema.mapper.userrequestdetailmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class UserProfilePageController {

    private final UserMapper userMapper;

    @GetMapping("/user/profile")
    public String userProfilePage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {
        if (currentUser != null) {
            User user = currentUser.getUser();
            UserResponseDTO userResponse = userMapper.map(user);
            modelMap.addAttribute("user", userResponse);
            if (userResponse.getRole() == Role.USER) {
                return "main/userProfilePage";
            } else {
                return "admin/adminPage";
            }
        }
        return "redirect:/";
    }


}
