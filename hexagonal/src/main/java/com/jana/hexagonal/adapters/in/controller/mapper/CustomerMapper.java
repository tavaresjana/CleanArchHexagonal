package com.jana.hexagonal.adapters.in.controller.mapper;

import com.jana.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.jana.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.jana.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    //para ignorar os campos que não possue correspondência entre as tabelas de custumer e customerRequest devemos utilizar o @Mapping(target = "nome", ignore=true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);


    CustomerResponse toCustomerResponse(Customer customer);

}
