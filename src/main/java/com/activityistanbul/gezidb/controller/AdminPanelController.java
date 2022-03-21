package com.activityistanbul.gezidb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPanelController {

    @RequestMapping(value = "/adminpanel")
    public String look(){
        return "AdminPanel";
    }
}
