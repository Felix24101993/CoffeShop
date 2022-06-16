package com.endava.mentorship2022.controller;
import com.endava.mentorship2022.service.TechnicalDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/technicaldetail")
@AllArgsConstructor
public class TechnicalDetailController {
    private final TechnicalDetailService technicalDetailService;

    // View technicaldetail for a specific product
    @GetMapping("/{productId}")
    public List viewTechnicalDetail(@PathVariable long productId) {
        return technicalDetailService.findAllByProductId(productId);
    }
}