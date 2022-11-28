package com.example.cinema.controller.userdetailcontroller.usercontroller;

import com.example.cinema.entity.userDetail.User;
import com.example.cinema.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class UserController {

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
        if (userService.isPictureNotAllowedType(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/register";
        }
        userService.registerUser(user, multipartFile);
        return "redirect:/user/login";

    }

    @GetMapping("/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("picName") String fileName) {
        if (userService.getUserImage(fileName) == null){
           return null;
        }
        return userService.getUserImage(fileName);
    }

}