package com.spring5.mvc.rest.mapper;

import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.model.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    CategoryDTO  categoryToCategoryDto(Category category);
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);
}
