package com.MecroECommerce.Customers.Mapper;

import com.MecroECommerce.Customers.Models.CustomerModel;
import com.MecroECommerce.Customers.Persistence.Customer;
import org.mapstruct.Mapper;

@Mapper
public interface ICustomerMapper {
    CustomerModel CustomerToCustomerModel(Customer customer);
    Customer CustomerModelToCustomer(CustomerModel customerModel);
}
