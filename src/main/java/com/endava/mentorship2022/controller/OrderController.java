package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.Order;
import com.endava.mentorship2022.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    //View all orders
    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }

    // View orders for a specific user
    @GetMapping("user/{userId}")
    public List<Order> findOrdersByUserId(@PathVariable long userId) {
        return orderService.findOrdersByUserId(userId);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable long id){
        return orderService.findById(id);
    }

}
