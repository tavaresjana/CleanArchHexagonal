package com.jana.hexagonal.config;

import com.jana.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.jana.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.jana.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.jana.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase, //aqui tivemos que usar o useCase pois o adapter estava dando erro, pois ele é a impl da porta de saída
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter

    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
