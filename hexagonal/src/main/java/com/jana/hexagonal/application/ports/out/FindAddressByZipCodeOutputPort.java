package com.jana.hexagonal.application.ports.out;

import com.jana.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}

