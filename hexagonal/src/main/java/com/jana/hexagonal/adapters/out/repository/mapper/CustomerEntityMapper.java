package com.jana.hexagonal.adapters.out.repository.mapper;

import com.jana.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.jana.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.jana.hexagonal.application.core.domain.Address;
import com.jana.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    //@Mapping(source = "address", target = "address")
    CustomerEntity toCustomerEntity(Customer customer);

    //@Mapping(source = "address", target = "address")
    Customer toCustomer(CustomerEntity customerEntity);

    default AddressEntity mapAddressToAddressEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(address.getStreet());
        addressEntity.setCity(address.getCity());
        return addressEntity;
    }

    default Address mapAddressEntityToAddress(AddressEntity addressEntity) {
        Address address = new Address();
        address.setStreet(addressEntity.getStreet());
        address.setCity(addressEntity.getCity());
        return address;
    }
}