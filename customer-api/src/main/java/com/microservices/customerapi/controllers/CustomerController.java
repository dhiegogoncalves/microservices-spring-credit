package com.microservices.customerapi.controllers;

import com.microservices.customerapi.controllers.dtos.CustomerRequest;
import com.microservices.customerapi.controllers.dtos.CustomerResponse;
import com.microservices.customerapi.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("customers")
@RestController
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CustomerRequest request) {
        var customer = request.toModel();
        service.save(customer);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/cpf/{id}")
                .buildAndExpand(customer.getCpf())
                .toUri()).build();
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity findByCpf(@PathVariable String cpf) {
        var customer = service.findByCpf(cpf);
        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer.map(CustomerResponse::toDto));
    }
}
