package com.MecroECommerce.Customers.Services;

import com.MecroECommerce.Customers.Mapper.ICustomerMapper;
import com.MecroECommerce.Customers.Models.CustomerModel;
import com.MecroECommerce.Customers.Persistence.Customer;
import com.MecroECommerce.Customers.Persistence.ICustomerDbContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerDbContext customerDbContext;

    @Autowired
    private ICustomerMapper mapper;


    @Override
    public List<CustomerModel> GetCustomers() {
        return customerDbContext.findAll().stream().map(mapper::CustomerToCustomerModel).collect(Collectors.toList());
    }

    @Override
    public CustomerModel GetCustomerById(int id) {
        Optional<Customer> customer = customerDbContext.findById(id);
        return customer == null? new CustomerModel() : mapper.CustomerToCustomerModel(customer.get());
    }
}
