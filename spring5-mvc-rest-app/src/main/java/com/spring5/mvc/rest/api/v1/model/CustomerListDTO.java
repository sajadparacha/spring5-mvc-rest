package com.spring5.mvc.rest.api.v1.model;

import com.spring5.model.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CustomerListDTO {
     List<CustomerDTO> customers;
}
