package com.vinnilmg.cleanarchitecture.config;

import com.vinnilmg.cleanarchitecture.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.FindAddressByZipCodeImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.InsertCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
            FindAddressByZipCodeImpl findAddressByZipCode,
            InsertCustomerImpl insertCustomer
    ) {
        return new InsertCustomerUseCaseImpl(findAddressByZipCode, insertCustomer);
    }
}
