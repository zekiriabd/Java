package com.MecroECommerce.Products.Mapper;

import com.MecroECommerce.Products.Models.ProductModel;
import com.MecroECommerce.Products.Persistence.Product;
import org.mapstruct.Mapper;

@Mapper
public interface IProductMapper {
    ProductModel ProductToProductModel(Product product);
    Product ProductModelToProduct(ProductModel productModel);
}
