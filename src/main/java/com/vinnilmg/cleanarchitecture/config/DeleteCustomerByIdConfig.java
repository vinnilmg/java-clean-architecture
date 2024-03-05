package com.vinnilmg.cleanarchitecture.config;

import com.vinnilmg.cleanarchitecture.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.vinnilmg.cleanarchitecture.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.vinnilmg.cleanarchitecture.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomerById);
    }
}
