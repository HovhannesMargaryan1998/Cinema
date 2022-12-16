package com.example.cinema.controller.userdetailcontroller;


import com.example.cinema.dto.userresponsedto.UserResponseDTO;
import com.example.cinema.entity.userdetail.Role;
import com.example.cinema.mapper.userrequestmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
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

    @GetMapping("/user/profile")
    public String userProfilePage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {
        if (currentUser != null) {
            UserResponseDTO userResponseDTO = userMapper.map(currentUser.getUser());
            if (userResponseDTO.getRole() == Role.USER) {
                userService.addAttributeForAdminPage(modelMap, userResponseDTO);
                return "main/userProfilePage";
            } else {
                return "admin/adminPage";
            }
        }
        return "redirect:/";
    }


}
