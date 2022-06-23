
package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.OrderNotFound;
import com.endava.mentorship2022.model.*;
import com.endava.mentorship2022.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserService userService;

    public List<Order> findAll() {
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

    public Order updateStatus(Long id, OrderStatus newStatus) {
        Order order = findById(id);
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    public Order createOrder(long userId, List<CartItem> cartItems) {

        User user = userService.findById(userId);
        Order newOrder = new Order();
        newOrder.setTotal(calculateTotal(cartItems));
        newOrder.setUser(user);
        Set<OrderDetail> orderDetails = newOrder.getOrderDetails();

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(newOrder);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setUnitPrice(product.getPrice());
            orderDetail.setSubtotal(cartItem.getSubtotal());
            orderDetails.add(orderDetail);
        }

        return orderRepository.save(newOrder);

    }

    private float calculateTotal(List<CartItem> cartItems) {

        float total = 0.0F;
        for (CartItem cartItem : cartItems) {
            total += cartItem.getSubtotal();
        }

        return total;

    }

}