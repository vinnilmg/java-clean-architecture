package com.vinnilmg.cleanarchitecture.dataprovider;

import com.vinnilmg.cleanarchitecture.core.dataprovider.DeleteCustomerById;
import com.vinnilmg.cleanarchitecture.dataprovider.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
