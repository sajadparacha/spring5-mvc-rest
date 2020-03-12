package com.spring5.mvc.rest.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String  firstName;
    private String  lastName;
    private String customerURL;
}
