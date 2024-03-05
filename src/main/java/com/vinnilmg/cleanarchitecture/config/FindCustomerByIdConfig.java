package com.vinnilmg.cleanarchitecture.config;

import com.vinnilmg.cleanarchitecture.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerByIdImpl findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(findCustomerById);
    }
}
