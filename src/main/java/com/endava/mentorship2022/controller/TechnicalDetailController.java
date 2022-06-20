package com.endava.mentorship2022.controller;
import com.endava.mentorship2022.model.TechnicalDetail;
import com.endava.mentorship2022.service.TechnicalDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technical-details")
@AllArgsConstructor
public class TechnicalDetailController {

    private final TechnicalDetailService technicalDetailService;

    @GetMapping
    public List<TechnicalDetail> findAll() {
        return technicalDetailService.findAll();
    }


    @GetMapping("/{id}")
    public TechnicalDetail findByIdTechnicalDetail(@PathVariable Long id) {
        return technicalDetailService.findById(id);
    }

    @PostMapping
    public TechnicalDetail save(@RequestBody TechnicalDetail technicalDetail) {
        return technicalDetailService.createTechnicalDetail(technicalDetail);
    }

    @PutMapping("/{id}")
    public TechnicalDetail updateTechnicalDetail(@PathVariable Long id, @RequestBody TechnicalDetail newTechnicalDetail) {
        return technicalDetailService.updateTechnicalDetail(id, newTechnicalDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteTechnicalDetail(@PathVariable Long id) {
        technicalDetailService.deleteTechnicalDetail(id);
    }

}