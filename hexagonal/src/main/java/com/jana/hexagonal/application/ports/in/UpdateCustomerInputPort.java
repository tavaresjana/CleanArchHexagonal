package com.jana.hexagonal.application.ports.in;

import com.jana.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
