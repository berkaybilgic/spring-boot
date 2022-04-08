package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.BarlarDao;
import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.service.Concretes.BarlarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DetayController {

    private BarlarDao barlarDao;
    private BarlarManager barlarManager;

    @Autowired
    public DetayController(BarlarDao barlarDao, BarlarManager barlarManager) {
        super();
        this.barlarDao = barlarDao;
        this.barlarManager = barlarManager;

    }


    @GetMapping(value = {"/detay ","/detay/{id}"} )
    public String DetayListele(Model model, @PathVariable(required = false ) Integer id)
    {
        Optional<Barlar> barlar = barlarDao.findById(id);

        model.addAttribute("barlar2",barlar.orElse(null));

        return "DetaySayfası";
    }

}
