package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.MekanlarDao;
import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.entites.Mekanlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MekanController {

    MekanlarDao mekanlarDao;

    @Autowired
    public MekanController(MekanlarDao mekanlarDao) {
        super();
        this.mekanlarDao = mekanlarDao;
    }

    @RequestMapping(value = "/listele")
    public String listele(Model model, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);

        Page<Mekanlar> list = mekanlarDao.findAllX(PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, "mekanId")));

        model.addAttribute("mekanlar", list);


        long pago = list.getTotalElements() / pageSize + 1;

        model.addAttribute("pago", pago);

        return "Listele";
    }



}
