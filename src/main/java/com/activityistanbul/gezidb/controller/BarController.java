package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.BarlarDao;
import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.service.Concretes.BarlarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BarController {
    private Integer pagesize = 8;

    private BarlarDao barlarDao;
    private BarlarManager barlarManager;

    public BarController(Integer Pagesize) {
        this.pagesize = pagesize;
    }

    @Autowired
    public BarController(BarlarDao barlarDao, BarlarManager barlarManager) {
        super();
        this.barlarDao = barlarDao;
        this.barlarManager = barlarManager;

    }

    @RequestMapping(value = "/ekle")
    public String ekranaGonder(Model model, @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);

        Page<Barlar> list = this.barlarDao
                .findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, "barId")));

        model.addAttribute("barlar", list);


        long pago = list.getTotalElements() / pageSize + 1;

        model.addAttribute("pago", pago);

        return "EkranaYazdırma";
    }



    @RequestMapping(value = "/panel")
    public String ekle(Model model) {
        Barlar feedback = new Barlar();
        model.addAttribute("bar", feedback);
        return "BarPanel";
    }

    @PostMapping("/panel")
    public String greetingSubmit(@ModelAttribute Barlar barlar, RedirectAttributes redirectAttributes) {
        try{
            barlarDao.save(barlar);
            redirectAttributes.addFlashAttribute("message", "Success");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-success");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("message", "Bu Mağaza ismi bulunuyor");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-danger");
        }

       return  "redirect:/panel";
    }



    /*
    @RequestMapping(value = "/panel")
    public String ekle(@RequestParam(value = "barLocation", required = false) String barLocation,
                       @RequestParam(value = "barName", required = false) String barName,
                       @RequestParam(value = "action", required = false) String action,
                       @RequestParam(value = "barId", required = false) Integer barId,
                       @RequestParam(value = "barImg", required = false) String barImg,
                       @RequestParam(value = "barDescription", required = false) String barDescription,
                       Model model,
                       Barlar barlar
    ) {

        List<Barlar> list = new ArrayList<>();

        barlar.setBarId(barId);
        barlar.setBarName(barName);
        barlar.setBarLocation(barLocation);
        barlar.setBarImg(barImg);
        barlar.setBarDescription(barDescription);
        list.add(barlar);
        barlarDao.saveAll(list);

        return "BarPanel";

    }*/
}
