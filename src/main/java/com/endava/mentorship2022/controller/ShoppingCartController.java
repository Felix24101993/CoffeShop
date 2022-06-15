package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.service.ShoppingCartService;
import com.endava.mentorship2022.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService cartService;

    private final UserService userService;

    // View cart for a specific user (it should be the logged one but not until security is implemented)
    @GetMapping("/{userId}")
    public List<CartItem> viewCart(@PathVariable long userId) {
        User user = userService.findById(userId);
        List<CartItem> cartItems = cartService.listCartItems(user);

        float estimatedTotal = 0.0F;
        for (CartItem item : cartItems) {
            estimatedTotal += item.getSubtotal(); // Total to pay
        }
        log.info("Cart total: " + estimatedTotal);
        return cartItems;
    }

}
