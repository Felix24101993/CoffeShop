package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ShoppingCartService {

    private final CartItemRepository cartItemRepository;

    // List Shopping Cart for User
    public List<CartItem> listCartItems(User user) {
        return cartItemRepository.findByUser(user);
    }

}
