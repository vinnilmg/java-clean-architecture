package com.vinnilmg.cleanarchitecture.dataprovider;

import com.vinnilmg.cleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.vinnilmg.cleanarchitecture.core.domain.Address;
import com.vinnilmg.cleanarchitecture.dataprovider.client.FindAddressByZipCodeClient;
import com.vinnilmg.cleanarchitecture.dataprovider.client.mapper.AddressResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
