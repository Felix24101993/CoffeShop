package com.endava.mentorship2022.service;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.model.TechnicalDetails;
import com.endava.mentorship2022.repository.TechnicalDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TechnicalDetailsService {
    private final TechnicalDetailsRepository technicalDetailsRepository;
    private final ProductService productService;

    public List<TechnicalDetails> findAllByProductId(long productId) {
        Product product = productService.findById(productId);
        return technicalDetailsRepository.findByProduct(product);
    }

}
