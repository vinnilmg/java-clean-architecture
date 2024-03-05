package com.vinnilmg.cleanarchitecture.core.usecase.impl;

import com.vinnilmg.cleanarchitecture.core.dataprovider.FindCustomerById;
import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        // Regra de negócio
        return findCustomerById.find(id)
                .orElseThrow(this::throwCustomerNotFound);
    }

    private RuntimeException throwCustomerNotFound() {
        return new RuntimeException("Customer not found.");
    }
}
