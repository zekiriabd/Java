package com.MecroECommerce.Products.Services;


import com.MecroECommerce.Products.Models.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductService {
    List<ProductModel> GetProducts();
    ProductModel GetProductById(int id);
}