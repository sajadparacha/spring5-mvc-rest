package com.spring5.mvc.rest.mapper;

import com.spring5.mvc.rest.api.v1.mapper.CategoryMapper;
import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.api.v1.model.CategoryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    public static final long ID = 1L;
    public static final String NAME = "Sajjad";

    @BeforeEach
    void setUp() {
    }

    @Test
    void categoryToCategoryDto() {
        Category category=new Category();
        category.setId(ID);
        category.setName(NAME);

        CategoryDTO categoryDTO= CategoryMapper.INSTANCE.categoryToCategoryDto(category);

        assertEquals(NAME,categoryDTO.getName());
        assertEquals(ID,categoryDTO.getId());
    }

    @Test
    void categoryDTOtoCategory() {
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(ID);
        categoryDTO.setName(NAME);

        Category category= CategoryMapper.INSTANCE.categoryDTOtoCategory(categoryDTO);

        assertEquals(NAME,category.getName());
        assertEquals(ID,category.getId());
    }
}