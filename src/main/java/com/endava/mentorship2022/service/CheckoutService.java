package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.CartItem;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CheckoutService {

    private final OrderService orderService;
    private final CartItemService cartItemService;

    public String placeOrder(long userId) {
        List<CartItem> cartItems = cartItemService.findCartItemsByUser(userId);
        if (cartItems.isEmpty()) {
            return "Cart is empty.";
        }
        orderService.createOrder(userId, cartItems);
        cartItemService.deleteCartByUser(userId);

        return "Order has been placed. Thank you for purchase.";
    }
}
