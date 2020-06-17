package com.MecroECommerce.Products.Services;

import com.MecroECommerce.Products.Mapper.IProductMapper;
import com.MecroECommerce.Products.Models.ProductModel;
import com.MecroECommerce.Products.Persistence.IProductDbContext;
import com.MecroECommerce.Products.Persistence.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductDbContext productDbContext;

    @Autowired
    private IProductMapper mapper;


    @Override
    public List<ProductModel> GetProducts() {
        return productDbContext.findAll().stream().map(mapper::ProductToProductModel).collect(Collectors.toList());
    }

    @Override
    public ProductModel GetProductById(int id) {
        Optional<Product> produict = productDbContext.findById(id);
        return produict == null? new ProductModel() : mapper.ProductToProductModel(produict.get());
    }
}
