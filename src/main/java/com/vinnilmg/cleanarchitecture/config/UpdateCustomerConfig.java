package com.vinnilmg.cleanarchitecture.config;

import com.vinnilmg.cleanarchitecture.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.vinnilmg.cleanarchitecture.core.usecase.impl.UpdateCustomerUseCaseImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.FindAddressByZipCodeImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            FindAddressByZipCodeImpl findAddressByZipCode,
            UpdateCustomerImpl updateCustomer
    ) {
        return new UpdateCustomerUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCode, updateCustomer);
    }
}
