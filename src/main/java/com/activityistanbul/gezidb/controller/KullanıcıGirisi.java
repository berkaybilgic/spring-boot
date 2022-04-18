package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.UsersDao;
import com.activityistanbul.gezidb.entites.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class KullanıcıGirisi {

    @Autowired
    UsersDao usersDao;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Users());

        return "signup_form";
    }



    @PostMapping("/process_register")
    public String processRegister(Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(users.getUserPassword());
        users.setUserPassword(encodedPassword);

        usersDao.save(users);

        return "home";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<Users> listUsers = usersDao.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }





}
