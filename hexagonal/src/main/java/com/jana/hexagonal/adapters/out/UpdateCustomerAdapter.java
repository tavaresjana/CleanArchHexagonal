package com.jana.hexagonal.adapters.out;

import com.jana.hexagonal.adapters.out.repository.CustomerRepository;
import com.jana.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.jana.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.jana.hexagonal.application.core.domain.Customer;
import com.jana.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
