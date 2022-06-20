package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.Order;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order newOrder) {
        return orderService.update(id, newOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
