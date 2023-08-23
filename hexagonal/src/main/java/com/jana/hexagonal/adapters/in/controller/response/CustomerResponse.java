package com.jana.hexagonal.adapters.in.controller.response;

import com.jana.hexagonal.adapters.out.client.response.AddressResponse;
import com.jana.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;
}
