package com.example.cinema.controller.userdetailcontroller.usercontroller;

import com.example.cinema.entity.userDetail.User;
import com.example.cinema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
                               ModelMap modelMap) throws IOException {
        if (userService.isPictureExist(multipartFile)){
            modelMap.addAttribute("errorMessageFile", "Please choose only image");
            return "main/mainHome";
        }
        userService.registerUser(user, multipartFile);
        return "redirect:/user/login";
    }

    @GetMapping("/getImage")
    public @ResponseBody byte[] getImage(@RequestParam("picName") String fileName) throws IOException {
        return userService.getUserImage(fileName);
    }

}