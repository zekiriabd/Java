package com.MecroECommerce.Customers.Controllers;

import com.MecroECommerce.Customers.Models.CustomerModel;
import com.MecroECommerce.Customers.Services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomersController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<CustomerModel>> getCustomers() {
        return ResponseEntity.ok(customerService.GetCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerById(@PathVariable int id) {
        return ResponseEntity.ok(customerService.GetCustomerById(id));
    }
}