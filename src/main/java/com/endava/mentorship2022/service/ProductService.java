package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.ProductNotFound;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteById(Long id){
        findById(id);
        productRepository.deleteById(id);
    }

    public Product updateProduct(long id, Product newProduct){
        Product productToUpdate = findById(id);
        productToUpdate.setName(newProduct.getName());
        productToUpdate.setAlias(newProduct.getAlias());
        productToUpdate.setBrand(newProduct.getBrand());
        productToUpdate.setDescription(newProduct.getDescription());
        productToUpdate.setCategory(newProduct.getCategory());
        productToUpdate.setEnabled(newProduct.isEnabled());
        productToUpdate.setPrice(newProduct.getPrice());
        productToUpdate.setStock(newProduct.getStock());
        return productRepository.save(productToUpdate);
    }
    public List<Product> findAllProductsSortedByPriceLowtoHigh() {
        return sortProductsByPriceLowToHigh(findAllProducts());
    }

    private List<Product> sortProductsByPriceLowToHigh(List<Product> products) {
        Comparator<Product> comparePriceFromLowestToHighest =
                Comparator.comparing(Product::getPrice);
        products.sort(comparePriceFromLowestToHighest);
        return products;
    }

    public List<Product> findAllProductsSortedByPriceHighToLow() {
        return sortProductsByPriceHighToLow(findAllProducts());
    }

    private List<Product> sortProductsByPriceHighToLow(List<Product> products) {
        Comparator<Product> comparePriceFromHighestToLowest =
                Comparator.comparing(Product::getPrice)
                        .reversed();
        products.sort(comparePriceFromHighestToLowest);
        return products;
    }
}
