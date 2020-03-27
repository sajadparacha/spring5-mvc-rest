package com.spring5.mvc.rest.api.v1.mapper;

import com.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.spring5.mvc.rest.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "id",target = "id")
    CategoryDTO categoryToCategoryDto(Category category);
    @Mapping(source = "id",target = "id")
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);
}
