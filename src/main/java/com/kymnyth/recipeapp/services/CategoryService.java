package com.kymnyth.recipeapp.services;

import com.kymnyth.recipeapp.domain.Category;
import com.kymnyth.recipeapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryByName(String categoryName){
        return categoryRepository.findCategoryByCategoryName(categoryName).get();
    }
}
