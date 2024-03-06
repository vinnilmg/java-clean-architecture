package com.vinnilmg.cleanarchitecture.entrypoint.consumer;

import com.vinnilmg.cleanarchitecture.core.usecase.UpdateCustomerUseCase;
import com.vinnilmg.cleanarchitecture.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.vinnilmg.cleanarchitecture.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "${vinnilmg.kafka.group}")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerUseCase.update(customer, customerMessage.getZipCode());
    }
}
