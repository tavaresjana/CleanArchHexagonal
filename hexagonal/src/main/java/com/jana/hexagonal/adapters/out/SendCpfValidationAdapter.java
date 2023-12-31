package com.jana.hexagonal.adapters.out;

import com.jana.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        String topic;
        kafkaTemplate.send(topic = "tp-cpf-validation", cpf);
    }
}
