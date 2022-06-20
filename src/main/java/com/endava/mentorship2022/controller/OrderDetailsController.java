package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.model.OrderDetails;
import com.endava.mentorship2022.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-details")
@AllArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @GetMapping
    public List<OrderDetails> findAll() {
        return orderDetailsService.findAll();
    }

    @GetMapping("/{id}")
    public List<OrderDetails> findByOrderId(@PathVariable long id) {
        return orderDetailsService.findByOrderId(id);
    }

}
