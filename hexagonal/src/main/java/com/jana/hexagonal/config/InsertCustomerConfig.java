package com.jana.hexagonal.config;

import com.jana.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.jana.hexagonal.adapters.out.InsertCustomerAdapter;
import com.jana.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.jana.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {

        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
