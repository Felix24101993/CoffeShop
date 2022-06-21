package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return cartItemService.listCartItems(userId);
    }

}
