package com.shahraz.controller;

import com.shahraz.model.Visitor;
import com.shahraz.service.VisitorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class VisitorController {

    private final VisitorService visitorService;

    @GetMapping("/get/{id}")
    public Visitor findVisitorById(@PathVariable long id){
        return visitorService.findById(id);
    }

    @GetMapping("/get-all")
    public List<Visitor> findAllVisitors(){
        return visitorService.findAll();
    }

    @GetMapping("/get-all-page")
    public Page<Visitor> findAllInPageable(){
        return visitorService.findAllPages();
    }
}

