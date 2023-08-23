package com.jana.hexagonal.adapters.out.client.mapper;

import com.jana.hexagonal.adapters.out.client.response.AddressResponse;
import com.jana.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    //convertendo o AdressResponse para um Adress
    Address toAddress(AddressResponse addressResponse);
}
