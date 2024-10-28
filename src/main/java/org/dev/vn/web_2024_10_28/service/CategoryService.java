package org.dev.vn.web_2024_10_28.service;

import org.dev.vn.web_2024_10_28.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Page<Category> getAllCategories(String search, Pageable pageable);
    Optional<Category> getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
