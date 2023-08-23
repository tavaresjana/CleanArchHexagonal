package com.jana.hexagonal.config;

import com.jana.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.jana.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.jana.hexagonal.adapters.out.InsertCustomerAdapter;
import com.jana.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.jana.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {

        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}