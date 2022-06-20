package com.endava.mentorship2022.service;

import com.endava.mentorship2022.model.OrderDetails;
import com.endava.mentorship2022.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public List<OrderDetails> findByOrderId(long orderId) {
        return orderDetailsRepository.findByOrderId(orderId);
    }

}
