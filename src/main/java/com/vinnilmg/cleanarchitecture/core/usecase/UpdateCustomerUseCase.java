package com.vinnilmg.cleanarchitecture.core.usecase;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;

public interface UpdateCustomerUseCase {

    void update(Customer customer, String zipCode);
}
