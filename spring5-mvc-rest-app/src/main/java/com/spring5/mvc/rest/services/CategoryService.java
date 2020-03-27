package com.spring5.mvc.rest.services;



import com.spring5.mvc.rest.api.v1.model.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}