package com.jana.hexagonal.adapters.out;

import com.jana.hexagonal.adapters.out.repository.CustomerRepository;
import com.jana.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.jana.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.jana.hexagonal.application.core.domain.Customer;
import com.jana.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
        /*Como faço para transformar esse Optional<CustomerEntity> para Customer?
         * você pega o customerEntity.map e para cada entity ele vai retornar um customer, mas para isso acontecer chamamos o mapper e assim ele converterá utilizando o toCustomer();
         */

    }
}
