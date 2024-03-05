package com.vinnilmg.cleanarchitecture.entrypoint.controller.mapper;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.entrypoint.controller.request.CustomerRequest;
import com.vinnilmg.cleanarchitecture.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
