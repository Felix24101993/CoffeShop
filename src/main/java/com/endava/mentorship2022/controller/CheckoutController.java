package com.endava.mentorship2022.controller;

import com.endava.mentorship2022.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/{userId}")
    public String placeOrder(@PathVariable long userId) {
        return checkoutService.placeOrder(userId);
    }

}
