package com.vinnilmg.cleanarchitecture.core.usecase.impl;

import com.vinnilmg.cleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.vinnilmg.cleanarchitecture.core.dataprovider.UpdateCustomer;
import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.vinnilmg.cleanarchitecture.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final FindCustomerByIdUseCase findCustomerByIdUseCase;
    private final FindAddressByZipCode findAddressByZipCode;
    private final UpdateCustomer updateCustomer;

    public UpdateCustomerUseCaseImpl(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCode findAddressByZipCode,
            UpdateCustomer updateCustomer
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
        this.updateCustomer = updateCustomer;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.find(customer.getId());

        // Alterando o endereço para o que veio do dataprovider
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);

        updateCustomer.update(customer);
    }
}
