package com.vinnilmg.cleanarchitecture.core.dataprovider;

import com.vinnilmg.cleanarchitecture.core.domain.Address;

public interface FindAddressByZipCode {

    Address find(final String zipCode);
}
