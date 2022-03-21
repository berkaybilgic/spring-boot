package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.BarlarDao;
import com.activityistanbul.gezidb.entites.Barlar;


import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class BarController  {


    private BarlarDao barlarDao;

    @Autowired
    public BarController(BarlarDao barlarDao) {
        super();
        this.barlarDao=barlarDao;
    }


    @RequestMapping(value = "/ekle")
    public String ekranaGonder(Model model){
        List<Barlar> list;
        list = this.barlarDao.findAll();
        model.addAttribute("barlar",list);

        return "EkranaYazdırma";
    }

}
