package com.endava.mentorship2022.repository;

import com.endava.mentorship2022.model.TechnicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetails, Long> {
    List<TechnicalDetails> findAllByProduct(Long id);

}



