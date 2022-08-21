package com.microservices.customerapi.services;

import com.microservices.customerapi.models.Customer;
import com.microservices.customerapi.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Transactional
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Optional<Customer> findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
