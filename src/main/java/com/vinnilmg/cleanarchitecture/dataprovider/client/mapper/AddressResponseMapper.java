package com.vinnilmg.cleanarchitecture.dataprovider.client.mapper;

import com.vinnilmg.cleanarchitecture.core.domain.Address;
import com.vinnilmg.cleanarchitecture.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
