package com.vinnilmg.cleanarchitecture.core.usecase;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;

public interface InsertCustomerUseCase {

    void insert(Customer customer, String zipCode);
}
