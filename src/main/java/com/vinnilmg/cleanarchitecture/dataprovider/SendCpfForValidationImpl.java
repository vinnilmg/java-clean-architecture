package com.vinnilmg.cleanarchitecture.dataprovider;

import com.vinnilmg.cleanarchitecture.core.dataprovider.SendCpfForValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCpfForValidationImpl implements SendCpfForValidation {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
