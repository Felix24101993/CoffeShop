
package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.OrderNotFound;
import com.endava.mentorship2022.model.Order;
import com.endava.mentorship2022.model.OrderStatus;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public List<Order> findOrdersByUserId(Long userId) {
        User user = userService.findById(userId);
        return orderRepository.findByUser(user);
    }

    public Order findById(long id) {
        return orderRepository.findById(id).
                orElseThrow(() -> new OrderNotFound("Order: " + id + " not found."));
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    public void updateStatus(Long id, OrderStatus newOrderStatus) {
        findById(id).setStatus(newOrderStatus);
    }

}