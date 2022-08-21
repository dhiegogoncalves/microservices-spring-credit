package com.microservices.customerapi.controllers.dtos;

import com.microservices.customerapi.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerResponse {
    private String cpf;
    private String name;
    private Integer age;

    public static CustomerResponse toDto(final Customer customer) {
        return new CustomerResponse(customer.getCpf(), customer.getName(), customer.getAge());
    }
}
