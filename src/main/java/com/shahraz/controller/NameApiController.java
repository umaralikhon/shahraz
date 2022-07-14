package com.shahraz.controller;

import com.shahraz.service.RandomUserService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class NameApiController {

    private final RandomUserService randomUserService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/save-user")
    public void saveRandomUser() {

        kafkaTemplate.send("save.visitor", "Success");
    }

    @GetMapping("/test-docker")
    public String helloDocker(){
        return "Hello from docker";
    }
}
