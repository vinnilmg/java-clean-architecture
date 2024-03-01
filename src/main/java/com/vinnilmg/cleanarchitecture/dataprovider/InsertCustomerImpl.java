package com.vinnilmg.cleanarchitecture.dataprovider;

import com.vinnilmg.cleanarchitecture.core.dataprovider.InsertCustomer;
import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.dataprovider.repository.CustomerRepository;
import com.vinnilmg.cleanarchitecture.dataprovider.repository.mapper.CustomerEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InsertCustomerImpl implements InsertCustomer {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
