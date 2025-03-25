package com.learning.SimpleWebApp.controllers;

import com.learning.SimpleWebApp.model.Product;
import com.learning.SimpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/")
    public String greet() {
        return "Product Management Service is running!";
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable  int productId) {
        return service.getProductById(productId);
    }

    @PostMapping("/product/add-product")
    public String addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return "Product Added successfully";
    }

    @PutMapping("/product/update-product")
    public String updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
        return "Product updated successfully";
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        service.deleteProduct(productId);
        return "Product deleted successfully";
    }
}
