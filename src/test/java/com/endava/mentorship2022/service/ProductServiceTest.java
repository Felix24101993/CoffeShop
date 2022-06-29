package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.ProductNotFound;
import com.endava.mentorship2022.exception.UserNotFound;
import com.endava.mentorship2022.model.*;
import com.endava.mentorship2022.repository.ProductRepository;
import com.endava.mentorship2022.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.endava.mentorship2022.model.UserStatus.ACTIVE;
import static com.endava.mentorship2022.model.UserStatus.PENDING;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    @DisplayName("Should find all products")
    void findAllProductsTest() {
        // given
        Product product1 = new Product(1l,
                "Tchibo cafea macinata",
                "Tchibo-cafea-macinata",
                "O cafea macinata foarte buna",
                "Tchibo",
                20,
                15,
                true,
                null,
                null
        );

        Product product2 = new Product(2l,
                "Lavazza cafea boabe",
                "Lavazza-cafea-boabe",
                "O cafea boabe foarte buna",
                "Lavazza",
                15,
                10,
                false,
                null,
                null
        );

        List<Product> productList = List.of(product1, product2);
        when(productRepository.findAll()).thenReturn(productList);

        // when
        List<Product> actualProducts = productService.findAllProducts();

        // then
        assertThat(actualProducts).hasSize(2);
        assertThat(productList).isEqualTo(actualProducts);
    }

    @Test
    @DisplayName("Should find a product by ID")
    void findProductByIdTest() throws ProductNotFound {
        // given
        Product productToBeFound = new Product(2l,
                "Lavazza cafea boabe",
                "Lavazza-cafea-boabe",
                "O cafea boabe foarte buna",
                "Lavazza",
                15,
                10,
                false,
                null,
                null
        );

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(productToBeFound));

        // when
        Product actualProduct = productService.findById(anyLong());

        // then
        assertThat(actualProduct).isEqualTo(productToBeFound);
    }

    @Test
    @DisplayName("Should throw ProductNotFound Exception")
    void findProductById_ExceptionTest() {
        // given
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThrows(ProductNotFound.class, () -> productService.findById(anyLong()));
    }

    @Test
    @DisplayName("Should update a product")
    void updateProductTest() {
        // given
        Product productToBeUpdated = new Product(2l,
                "Lavazza cafea boabe",
                "Lavazza-cafea-boabe",
                "O cafea boabe foarte buna",
                "Lavazza",
                15,
                10,
                false,
                null,
                null
        );

        Product newProduct = new Product(2l,
                "Lavazza cafea boabe",
                "Lavazza-cafea-boabe",
                "O cafea boabe foarte buna",
                "Lavazza",
                15,
                10,
                false,
                null,
                null
        );

        when(productRepository.findById(anyLong())).thenReturn(Optional.of(productToBeUpdated));
        when(productRepository.save(productToBeUpdated)).thenReturn(newProduct);

        // when
        Product resultedProduct = productService.updateProduct(anyLong(), newProduct);

        //then
        assertThat(resultedProduct).isEqualTo(newProduct);
    }

    @Test
    @DisplayName("Should throw ProductNotFound Exception")
    void updateProduct_ExceptionTest() {
        // given
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        // then
        assertThrows(ProductNotFound.class, () -> productService.deleteById(anyLong()));
    }

    @Test
    @DisplayName("Should save a product")
    void saveProductTest() {
        // given
        Product product = new Product(2l,
                "Lavazza cafea boabe",
                "Lavazza-cafea-boabe",
                "O cafea boabe foarte buna",
                "Lavazza",
                15,
                10,
                false,
                null,
                null
        );

        when(productRepository.save(product)).thenReturn(product);

        // when
        Product newProduct = productService.saveProduct(product);

        // then
        assertThat(newProduct).isEqualTo(product);
    }

}