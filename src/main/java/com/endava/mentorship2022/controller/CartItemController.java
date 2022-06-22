package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{userId}")
    public List<CartItem> viewCart(@PathVariable long userId) {
        return cartItemService.findCartItemsByUser(userId);
    }

    @PostMapping("/{userId}/add/{productId}/{quantity}")
    public String addProductToCart(@PathVariable long userId, @PathVariable long productId, @PathVariable short quantity) {
        return cartItemService.addProductToCart(userId, productId, quantity);
    }

    @PutMapping("/{userId}/update/{productId}/{quantity}")
    public String updateProductQuantity(@PathVariable long userId, @PathVariable long productId, @PathVariable short quantity) {
        return cartItemService.updateProductQuantity(userId, productId, quantity);
    }

    @DeleteMapping("/{userId}/remove/{productId}")
    public String removeProductFromCart(@PathVariable long userId, @PathVariable long productId) {
        return cartItemService.removeProductFromCart(userId, productId);
    }

    @DeleteMapping("/{userId}")
    public String deleteCart(@PathVariable long userId) {
        return cartItemService.deleteCartByUser(userId);
    }

}