package com.example.cinema.controller.userdetailcontroller.admincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

    @GetMapping("/admin/page")
    public String adminPage(){
        return "redirect:/user/profile";
    }

    @GetMapping("/add/items")
    public String addItemsPage() {
        return "admin/addItem";
    }

    @GetMapping("/catalog/films")
    public String CatalogFilmsPage() {
        return "admin/catalogFilms";
    }

    @GetMapping("/users/all")
    public String allUsersPage() {
        return "admin/allUsers";
    }

    @GetMapping("/all/comments/page")
    public String allCommentsPage() {
        return "admin/allComments";
    }

    @GetMapping("/edit/user")
    public String editUserPage() {
        return "admin/editUser";
    }


}
