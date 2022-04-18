package com.activityistanbul.gezidb.controller;

import com.activityistanbul.gezidb.dataAcces.MekanlarDao;
import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.entites.Mekanlar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminPanelController {

    MekanlarDao mekanlarDao;

    @Autowired
    public AdminPanelController (MekanlarDao mekanlarDao) {
        super();
        this.mekanlarDao = mekanlarDao;
    }

    @RequestMapping(value = "/admintablo")
    public String listele(Model model, @RequestParam("page") Optional<Integer> page,
                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(8);

        Page<Mekanlar> list = mekanlarDao.findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by(Sort.Direction.ASC, "mekanId")));

        model.addAttribute("mekanlar", list);


        long pago = list.getTotalElements() / pageSize + 1;

        model.addAttribute("pago", pago);

        return "AdminTablo";
    }





    @RequestMapping(value = "/adminpanel")
    public String adminPanel(Model model) {
        Mekanlar feedback = new Mekanlar();
        model.addAttribute("mekan", feedback);
        return "MekanPanel";
    }

    @PostMapping("/adminpanel")
    public String adminPanelSubmit(@ModelAttribute Mekanlar mekanlar, RedirectAttributes redirectAttributes) {
        try {
            mekanlarDao.save(mekanlar);
            redirectAttributes.addFlashAttribute("message", "Success");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-success");
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("message", "Bu Mağaza ismi bulunuyor");
            redirectAttributes.addFlashAttribute("alertClass", "alert alert-danger");
        }

        return "redirect:/adminpanel";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete (@PathVariable(required = false) Integer id, Model model) {

        mekanlarDao.deleteById(id);

        return "redirect:/admintablo";
    }


    @RequestMapping(value = "/update/{id}")
    public String update (Model model, @PathVariable(required = false) Integer id ) {
        Mekanlar feedback = new Mekanlar();
        model.addAttribute("mekan", feedback);

        Optional<Mekanlar>  urlx = mekanlarDao.findById(id);
        model.addAttribute("urlx", urlx.orElse(null));

        return "Update";
    }


        @PostMapping("/update/{id}")
    public String updateSubmit (@ModelAttribute Mekanlar mekanlar, RedirectAttributes redirectAttributes,
                                @PathVariable(required = false) Integer id, Model model) {

        mekanlar.setMekanId(id);
        mekanlarDao.save(mekanlar);

        return "redirect:/admintablo";
    }








}
