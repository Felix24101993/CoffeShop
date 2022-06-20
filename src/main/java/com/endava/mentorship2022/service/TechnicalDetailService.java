package com.endava.mentorship2022.service;
import com.endava.mentorship2022.exception.TechnicalDetailNotFound;
import com.endava.mentorship2022.model.TechnicalDetail;
import com.endava.mentorship2022.repository.TechnicalDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class TechnicalDetailService {

    private final TechnicalDetailRepository technicalDetailRepository;

    public List<TechnicalDetail> findAll() {
        return technicalDetailRepository.findAll();
    }

    public TechnicalDetail findById(Long id) {
        return technicalDetailRepository.findById(id).orElseThrow(() -> new TechnicalDetailNotFound("TechnicalDetail: " + id + " not found."));
    }

    public TechnicalDetail createTechnicalDetail(TechnicalDetail technicalDetail) {
        return technicalDetailRepository.save(technicalDetail);
    }

    public TechnicalDetail updateTechnicalDetail(Long id, TechnicalDetail newTechnicalDetail) {
        TechnicalDetail technicalDetailToUpdate = findById(id);
        technicalDetailToUpdate.setName(newTechnicalDetail.getName());
        technicalDetailToUpdate.setValue(newTechnicalDetail.getValue());
        technicalDetailToUpdate.setProduct(newTechnicalDetail.getProduct());
        return technicalDetailRepository.save(technicalDetailToUpdate);
    }

    public void deleteTechnicalDetail(Long id) {
        boolean technicalDetailExists = technicalDetailRepository.existsById(id);
        if (!technicalDetailExists) {
            throw new IllegalStateException(String.format("TechnicalDetail with id %s does not exist", id));
        }
        technicalDetailRepository.deleteById(id);
    }

}