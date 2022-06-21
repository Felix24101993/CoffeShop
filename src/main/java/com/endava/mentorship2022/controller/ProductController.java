package com.endava.mentorship2022.controller;


import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.findAllProducts();
    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable long id){
        return productService.findById(id);
    }
}
