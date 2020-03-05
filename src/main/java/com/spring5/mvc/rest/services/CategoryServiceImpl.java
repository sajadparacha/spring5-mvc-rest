package com.spring5.mvc.rest.services;

import com.spring5.mvc.rest.mapper.CategoryMapper;
import com.spring5.mvc.rest.model.CategoryDTO;
import com.spring5.mvc.rest.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {

       return  categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {

        return categoryMapper.categoryToCategoryDto(categoryRepository.findByName(name));
    }
}
