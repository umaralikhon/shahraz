package com.shahraz.service;

import com.shahraz.model.Address;
import com.shahraz.model.Gender;
import com.shahraz.model.Visitor;
import com.shahraz.model.dto.ResultDto;
import com.shahraz.model.dto.Results;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RandomUserService {

    private final RestTemplate restTemplate;
    private final VisitorService visitorService;

    private Results results;

    private ResultDto getResultsFromNameApi() {

        return restTemplate.exchange(
                "https://randomuser.me/api/",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                ResultDto.class
        ).getBody();
    }

    public Visitor saveVisitor(){
        return visitorService.save(setVisitorData());
    }

    private Visitor setVisitorData(){
        Visitor visitor = new Visitor();
        results = new Results();
        results = getResultsFromNameApi().getResults().get(0);

        visitor.setFirstname(results.getName().getFirst());
        visitor.setLastname(results.getName().getLast());
        visitor.setEmail(results.getEmail());
        visitor.setUsername(results.getLogin().getUsername());
        visitor.setPassword(results.getLogin().getPassword());
        visitor.setRegistered(results.getRegistered().getDate());
        visitor.setAge(results.getRegistered().getAge());
        visitor.setPhone(results.getPhone());
        visitor.setGender(Gender.valueOf(results.getGender().toUpperCase()));
        visitor.setAddress(setVisitorAddress(results));

        return visitor;
    }

    private List<Address> setVisitorAddress(Results results){
        Address address = new Address();
        List<Address> addressList = new ArrayList<>();

        address.setStreet(results.getLocation().getStreet().getName());
        address.setCountry(results.getLocation().getCountry());
        address.setCity(results.getLocation().getCity());
        address.setNumber(results.getLocation().getStreet().getNumber());
        address.setState(results.getLocation().getState());

        return addressList;
    }
}
