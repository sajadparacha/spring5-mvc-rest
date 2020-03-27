package com.spring5.mvc.rest.api.v1.mapper;

//import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.model.CustomerDTO;
import com.spring5.mvc.rest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    @Mapping(source = "id",target = "id")
    CustomerDTO customerToCustomerDTO(com.spring5.mvc.rest.domain.Customer customer);
    @Mapping(source = "id",target = "id")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
