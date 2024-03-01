package com.vinnilmg.cleanarchitecture.dataprovider.repository.mapper;

import com.vinnilmg.cleanarchitecture.core.domain.Customer;
import com.vinnilmg.cleanarchitecture.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
