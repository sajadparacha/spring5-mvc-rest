package com.spring5.mvc.rest.services;



import com.spring5.mvc.rest.model.CategoryDTO;

import java.util.List;


public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}