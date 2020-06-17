package com.MecroECommerce.Customers.Services;


import com.MecroECommerce.Customers.Models.CustomerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerService {
    List<CustomerModel> GetCustomers();
    CustomerModel GetCustomerById(int id);
}