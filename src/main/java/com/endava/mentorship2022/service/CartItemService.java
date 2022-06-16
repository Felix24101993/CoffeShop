package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    private final UserService userService;

    // List shopping cart for user
    public List<CartItem> listCartItems(long userId) {
        User user = userService.findById(userId);
        List<CartItem> cartItems = cartItemRepository.findByUser(user);

        /* To be implemented after Product entity has been implemented
        float estimatedTotal = 0.0F;
        for (CartItem item : cartItems) {
            estimatedTotal += item.getSubtotal(); // Total to pay
        }
        log.info("Cart total: " + estimatedTotal);
        */

        return cartItemRepository.findByUser(user);
    }

}
