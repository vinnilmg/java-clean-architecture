package com.vinnilmg.cleanarchitecture.core.dataprovider;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer> find(final String id);
}
