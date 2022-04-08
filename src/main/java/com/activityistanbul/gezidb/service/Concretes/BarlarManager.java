package com.activityistanbul.gezidb.service.Concretes;

import com.activityistanbul.gezidb.dataAcces.BarlarDao;
import com.activityistanbul.gezidb.entites.Barlar;
import com.activityistanbul.gezidb.service.Abstracts.BarlarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class BarlarManager implements BarlarService {

    private BarlarDao barlarDao;

    @Autowired
    public BarlarManager(BarlarDao barlarDao) {
        super();
        this.barlarDao = barlarDao;
    }


    @Override
    public String add(Model model) {
        model.addAttribute("berkay",this.barlarDao.findAll());
        return "BarPanel";
    }

    public Page<Barlar> findPage(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber - 1,5);
        return barlarDao.findAll(pageable);





}}


