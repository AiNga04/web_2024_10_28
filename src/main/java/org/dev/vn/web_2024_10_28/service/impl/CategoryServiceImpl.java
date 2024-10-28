package org.dev.vn.web_2024_10_28.service.impl;

import org.dev.vn.web_2024_10_28.entity.Category;
import org.dev.vn.web_2024_10_28.repository.CategoryRepository;
import org.dev.vn.web_2024_10_28.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> getAllCategories(String search, Pageable pageable) {
        if (search == null || search.isEmpty()) {
            return categoryRepository.findAll(pageable);
        } else {
            return categoryRepository.findByNameContaining(search, pageable);
        }
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
