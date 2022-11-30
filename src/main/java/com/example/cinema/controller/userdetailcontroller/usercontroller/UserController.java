package com.example.cinema.controller.userdetailcontroller.usercontroller;

import com.example.cinema.dto.UserRequestDto;
import com.example.cinema.entity.userDetail.User;
import com.example.cinema.security.CurrentUser;
import com.example.cinema.service.userservice.UserService;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final CreatePictureUtil createPictureUtil;
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "main/login";
    }

    @GetMapping("/forgot/password")
    public String forgotPassword() {
        return "main/forgot";
    }

    @GetMapping("/user/login")
    public String LoginPage() {
        return "main/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "main/register";
    }

    @PostMapping("register/user")
    public String registerUser(@ModelAttribute User user, @RequestParam("image") MultipartFile multipartFile,
                               ModelMap modelMap) {
        if (createPictureUtil.isPictureNotAllowedType(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/register";
        }
        userService.registerUser(user, multipartFile);
        return "redirect:/user/login";
    }

    @GetMapping("/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("picName") String fileName) {
        if (createPictureUtil.getImage(fileName) == null){
           return null;
        }
        return createPictureUtil.getImage(fileName);
    }


    @GetMapping("/editUser")
    public String editUserPage(@AuthenticationPrincipal CurrentUser currentUser, ModelMap map) {
        map.addAttribute("user", currentUser.getUser());
        return "saveUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUserPage(@PathVariable("id") int id, @ModelAttribute UserRequestDto userRequestDto) {
        userService.update(id, userRequestDto);
        return "redirect:/";
    }



}