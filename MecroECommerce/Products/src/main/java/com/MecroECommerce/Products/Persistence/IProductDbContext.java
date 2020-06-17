package com.MecroECommerce.Products.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDbContext extends JpaRepository<Product,Integer> {

}




