package com.spring5.mvc.rest.api.v1.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data


public class CategoryDTO {

    private  Long id;
    private String name;
}
