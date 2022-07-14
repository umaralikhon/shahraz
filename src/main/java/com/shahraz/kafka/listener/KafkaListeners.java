package com.shahraz.kafka.listener;

import com.shahraz.service.RandomUserService;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final RandomUserService randomUserService;

    @KafkaListener(topics = "save.visitor", groupId = "visitor")
    void saveVisitorViaKafka(){
        for(int i = 0; i < 100; i++) {
            randomUserService.saveVisitor();
        }
    }
}
