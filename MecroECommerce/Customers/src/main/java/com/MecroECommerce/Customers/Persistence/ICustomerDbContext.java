package com.MecroECommerce.Customers.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDbContext extends JpaRepository<Customer,Integer> {

}




