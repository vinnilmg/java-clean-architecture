package com.vinnilmg.cleanarchitecture.entrypoint.controller;

import com.vinnilmg.cleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.vinnilmg.cleanarchitecture.core.usecase.InsertCustomerUseCase;
import com.vinnilmg.cleanarchitecture.entrypoint.controller.mapper.CustomerMapper;
import com.vinnilmg.cleanarchitecture.entrypoint.controller.request.CustomerRequest;
import com.vinnilmg.cleanarchitecture.entrypoint.controller.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
