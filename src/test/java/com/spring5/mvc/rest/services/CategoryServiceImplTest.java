package com.spring5.mvc.rest.services;

import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.api.v1.mapper.CategoryMapper;
import com.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.spring5.mvc.rest.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CategoryServiceImplTest {
    public static final String NAME = "Asian";
    //**We want to create a mock here as during this test we don't actually want to hit the database
    @Mock
    CategoryRepository categoryRepository;
    //**We will initialize the object of this class since we want to test this class here
    CategoryService categoryService;
    List<Category> categoryList;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.categoryService = new CategoryServiceImpl(categoryRepository, CategoryMapper.INSTANCE);
        categoryList= new ArrayList<>();
        categoryList.add(new Category());
        categoryList.add(new Category());
        categoryList.add(new Category());
        categoryList.add(new Category());
    }

    @Test
    void getAllCategories() {
        //Given
        //The list is already prepared in the setUp method
        when(categoryRepository.findAll()).thenReturn(categoryList);
        //When
         List<CategoryDTO> categories= categoryService.getAllCategories();
        //Then
        assertEquals(categories.size(),4);
    }

    @Test
    void getCategoryByName() {
        //Given
        Category category=new Category();
        category.setId(1L);
        category.setName(NAME);
        when(categoryRepository.findByName(any())).thenReturn(category);
        //When
        CategoryDTO dto= categoryService.getCategoryByName(NAME);
        //Then
        assertEquals(dto.getId(),category.getId());

    }
}