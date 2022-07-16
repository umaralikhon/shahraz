package com.shahraz.service;

import com.shahraz.model.Visitor;
import com.shahraz.service.repository.VisitorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VisitorServiceImpl implements VisitorService{

    private final VisitorRepository visitorRepository;

    @Override
    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor findById(long id) {
        Visitor visitor = null;
        Optional<Visitor> optional = visitorRepository.findById(id);

        if(optional.isPresent()){
            visitor = optional.get();
        }
        return visitor;
    }

    @Override
    public Visitor save(Visitor visitor) {
        return visitorRepository.save(visitor);
    }

    @Override
    public void saveAll(List<Visitor> visitors) {
        visitorRepository.saveAll(visitors);
    }

    @Override
    public Page<Visitor> findAllPages(){
        return visitorRepository.findAll(PageRequest.of(2,10));
    }
}
