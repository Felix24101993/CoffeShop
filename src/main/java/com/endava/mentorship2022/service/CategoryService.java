package com.endava.mentorship2022.service;

import com.endava.mentorship2022.exception.CategoryNotFound;
import com.endava.mentorship2022.model.Category;
import com.endava.mentorship2022.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFound("Category: " + id + " not found."));
    }

    public List<Category> findAllByParent(Long id){
        if(id == 0) {
            id = null;
            return categoryRepository.findAllByParent(id);
        } else {
            Category categoryParent = new Category(id);
            return categoryRepository.findAllByParent(categoryParent);
        }
    }

}
