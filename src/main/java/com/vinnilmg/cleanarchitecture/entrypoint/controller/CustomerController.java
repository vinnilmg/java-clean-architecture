package com.vinnilmg.cleanarchitecture.entrypoint.controller;

import com.vinnilmg.cleanarchitecture.core.usecase.DeleteCustomerByIdUseCase;
import com.vinnilmg.cleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.vinnilmg.cleanarchitecture.core.usecase.InsertCustomerUseCase;
import com.vinnilmg.cleanarchitecture.core.usecase.UpdateCustomerUseCase;
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

    private static final String PATH_PARAM_ID = "/{id}";

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerUseCase.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping(PATH_PARAM_ID)
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = findCustomerByIdUseCase.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping(PATH_PARAM_ID)
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);

        // Inserindo o ID no objeto
        customer.setId(id);

        updateCustomerUseCase.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(PATH_PARAM_ID)
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }
}
