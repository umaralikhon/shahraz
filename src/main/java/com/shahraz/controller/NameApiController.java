package com.shahraz.controller;

import com.shahraz.model.Visitor;
import com.shahraz.service.RandomUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class NameApiController {

    private final RandomUserService randomUserService;

    @GetMapping("/save-user")
    public Visitor saveRandomUser(){
        return randomUserService.saveVisitor();
    }
}
