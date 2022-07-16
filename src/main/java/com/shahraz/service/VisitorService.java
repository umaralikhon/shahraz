package com.shahraz.service;

import com.shahraz.model.Visitor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VisitorService {

    List<Visitor> findAll();
    Visitor findById(long id);
    Visitor save(Visitor visitor);
    void saveAll(List<Visitor> visitors);
    Page<Visitor> findAllPages();
}
