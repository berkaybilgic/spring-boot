package com.activityistanbul.gezidb.controller;



import com.activityistanbul.gezidb.dataAcces.UsersDao;
import com.activityistanbul.gezidb.entites.Giris;
import com.activityistanbul.gezidb.entites.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController   {

    @RequestMapping(value = "/home")
    public String getHomePage() {
        return "home";
    }


    @RequestMapping(value = "/about")
    public String getAbout() {




        return "about";
    }








}


