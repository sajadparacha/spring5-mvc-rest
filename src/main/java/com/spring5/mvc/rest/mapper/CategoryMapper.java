package com.spring5.mvc.rest.mapper;

import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.model.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "id",target = "id")
    CategoryDTO  categoryToCategoryDto(Category category);
    @Mapping(source = "id",target = "id")
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);
}
