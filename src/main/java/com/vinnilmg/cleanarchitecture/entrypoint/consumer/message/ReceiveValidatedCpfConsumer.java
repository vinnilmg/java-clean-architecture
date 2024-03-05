package com.vinnilmg.cleanarchitecture.entrypoint.consumer.message;

import com.vinnilmg.cleanarchitecture.core.usecase.UpdateCustomerUseCase;
import com.vinnilmg.cleanarchitecture.entrypoint.consumer.CustomerMessage;
import com.vinnilmg.cleanarchitecture.entrypoint.consumer.mapper.CustomerMessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "${vinnilmg.kafka.group}")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }
}
