package com.activityistanbul.gezidb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @RequestMapping(value = "/home")
    public String getHomePage() {
        return "Home";
    }

    @RequestMapping(value = "/about")
    public String getAbout(){
        return "about";
    }





}
