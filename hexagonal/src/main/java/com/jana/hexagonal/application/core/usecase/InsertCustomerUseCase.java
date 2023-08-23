package com.jana.hexagonal.application.core.usecase;

import com.jana.hexagonal.application.core.domain.Address;
import com.jana.hexagonal.application.core.domain.Customer;
import com.jana.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.jana.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.jana.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.jana.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {

        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf()); //enviando o cpf para a fila do kafka utilizando uma porta de output
    }
}

