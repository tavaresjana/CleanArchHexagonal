package com.jana.hexagonal.application.ports.in;

import com.jana.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
