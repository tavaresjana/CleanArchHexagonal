package com.jana.hexagonal.application.ports.out;

import com.jana.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
