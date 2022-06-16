package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.Order;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public List<Order> listOrders(Long userId) {
        User user = userService.findById(userId);

        return orderRepository.findByUser(user);
    }
}