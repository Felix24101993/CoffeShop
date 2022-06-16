package com.endava.mentorship2022.controller;
import com.endava.mentorship2022.service.TechnicalDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/technicaldetails")
@AllArgsConstructor
public class TechnicalDetailsController {
    private final TechnicalDetailsService technicalDetailsService;

    // View technicaldetails for a specific product
    @GetMapping("/{productId}")
    public List viewTechnicalDetails(@PathVariable Long productId) {
        return technicalDetailsService.TechnicalDetailsList(productId);
    }
}