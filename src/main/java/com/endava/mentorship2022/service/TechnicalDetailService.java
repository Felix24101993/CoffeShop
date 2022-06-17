package com.endava.mentorship2022.service;
import com.endava.mentorship2022.model.Product;
import com.endava.mentorship2022.model.TechnicalDetail;
import com.endava.mentorship2022.model.User;
import com.endava.mentorship2022.repository.TechnicalDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;



import java.util.List;
@Service
@AllArgsConstructor
public class TechnicalDetailService {
    private final TechnicalDetailRepository technicalDetailRepository;
   // private final ProductService productService;
    public List<TechnicalDetail> findAll() {
        return technicalDetailRepository.findAll();
    }


}
