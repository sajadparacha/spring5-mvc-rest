package com.spring5.mvc.rest.repositories;

import com.spring5.mvc.rest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByName(String name);
}