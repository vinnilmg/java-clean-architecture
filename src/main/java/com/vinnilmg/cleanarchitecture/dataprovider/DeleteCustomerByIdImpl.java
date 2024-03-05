package com.vinnilmg.cleanarchitecture.dataprovider;

import com.vinnilmg.cleanarchitecture.core.dataprovider.DeleteCustomerById;
import com.vinnilmg.cleanarchitecture.dataprovider.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

    private final CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
