package com.vinnilmg.cleanarchitecture.core.usecase;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;

public interface FindCustomerByIdUseCase {

    Customer find(final String id);
}
