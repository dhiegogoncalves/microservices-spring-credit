package com.microservices.customerapi.controllers.dtos;

import com.microservices.customerapi.models.Customer;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CustomerRequest {

    @CPF(message = "CPF não é valido")
    private String cpf;
    @NotBlank(message = "name é obrigatório")
    private String name;
    @NotNull(message = "age é obrigatório")
    private Integer age;

    public Customer toModel() {
        return new Customer(cpf.replaceAll("[^\\d ]", ""), name, age);
    }
}
