package com.jana.hexagonal.adapters.in.controller;

import com.jana.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.jana.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.jana.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.jana.hexagonal.adapters.out.repository.CustomerRepository;
import com.jana.hexagonal.application.core.domain.Customer;
import com.jana.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.jana.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.jana.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.jana.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.jana.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    @Autowired
    private CustomerMapper customerMapper;


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        /*no CustomerRequest nós não temos o id, mas ali no @PathVariable e no customer temos o id. Então pegamos o id do parametro e setamos no customer*/
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode()); /*como customer não tem zipCode, pegamos do customerRequest*/
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
