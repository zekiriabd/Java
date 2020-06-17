package com.MecroECommerce.Products.Controllers;

import com.MecroECommerce.Products.Models.ProductModel;
import com.MecroECommerce.Products.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductsController {

    @Autowired
    private IProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductModel>> getProducts() {
        return ResponseEntity.ok(productService.GetProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.GetProductById(id));
    }
}