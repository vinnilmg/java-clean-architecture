package com.vinnilmg.cleanarchitecture.core.usecase.impl;

import com.vinnilmg.cleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.vinnilmg.cleanarchitecture.core.dataprovider.InsertCustomer;
import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer
    ) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
    }
}
