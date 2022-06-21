package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.CartItem;
import com.endava.mentorship2022.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public List<CartItem> findCartItemsByUser(long userId) {
        return cartItemRepository.findByUserId(userId);
    }

}
