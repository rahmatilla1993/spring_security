package com.example.spring_security.controller;

import com.example.spring_security.models.Product;
import com.example.spring_security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public HttpEntity<?> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public HttpEntity<?> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok("Added");
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted");
    }
}
