package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.ProductNotFound;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFound("Product: " + id + " not found!"));
    }
}
