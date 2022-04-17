package com.example.spring_security.service;

import com.example.spring_security.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {
    private List<Product> products = Stream.of(
            new Product(1L, "Samsung Galaxy S22"),
            new Product(2L, "Iphone 13 Pro Max"),
            new Product(3L, "MI6")).collect(Collectors.toList());
    public List<Product> getProducts(){
        return products;
    }
    public Product getProduct(Long id){
        return products.stream().filter(product -> product.getId().
                equals(id)).findFirst().orElse(null);
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public void deleteProduct(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }
}
