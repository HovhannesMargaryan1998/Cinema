package com.example.cinema.controller.userdetailcontroller.usercontroller;

import com.example.cinema.dto.userrequestdetaildto.UserRequestDTO;

import com.example.cinema.dto.userrequestdetaildto.UserUpdateRequestDTO;
import com.example.cinema.entity.filmdetail.Comment;
import com.example.cinema.mapper.userrequestdetailmapper.UserMapper;
import com.example.cinema.security.CurrentUser;
import com.example.cinema.service.CommentService;
import com.example.cinema.service.UserService;
import com.example.cinema.util.CheckImportedData;
import com.example.cinema.util.CreatePictureUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final CreatePictureUtil createPictureUtil;
    private final CheckImportedData checkImportedData;
    private final UserService userService;
    private final CommentService commentService;
    private final UserMapper userMapper;

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

    @PostMapping("/register/user")
    public String registerUser(@ModelAttribute @Valid UserRequestDTO userRequestDTO, BindingResult bindingResult,
                               @RequestParam("imageUser") MultipartFile multipartFile, ModelMap modelMap) {
        if (checkImportedData.checkUserData(bindingResult, userRequestDTO, multipartFile, modelMap).isPresent()) {
            checkImportedData.checkUserData(bindingResult, userRequestDTO, multipartFile, modelMap).get();
            return "main/register";
        }
        userService.registerUser(userRequestDTO, multipartFile);
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
        map.addAttribute("user", userMapper.map(currentUser.getUser()));
        return "saveUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUserPage(@PathVariable("id") int id, @ModelAttribute UserUpdateRequestDTO userUpdateRequestDTO) {
        userService.update(id, userUpdateRequestDTO);
        return "redirect:/";
    }

    @GetMapping("/user/comments")
    public String userComments(@AuthenticationPrincipal CurrentUser currentUser, ModelMap modelMap) {
        List<Comment> commentByUserId = commentService.getCommentByUserId(currentUser.getUser().getId());
        modelMap.addAttribute("comments", commentByUserId);
        return "main/allComments";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUserById(@PathVariable("id") int id, ModelMap modelMap, Pageable pageable) {
        if (userService.deleteUserById(id)) {
            return "redirect:/users/all";
        }
        modelMap.addAttribute("countAllUsers", userService.getCountAllUsers());
        modelMap.addAttribute("allUsers", userService.getAllUsers(pageable));
        modelMap.addAttribute("idNotExist", "id not exist");
        return "admin/allUsers";
    }

}