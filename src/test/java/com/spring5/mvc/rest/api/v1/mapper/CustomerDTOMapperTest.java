package com.spring5.mvc.rest.api.v1.mapper;

import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CustomerDTOMapperTest {
    public static final String FIRST_NAME = "Sajjad";
    CustomerMapper customerMapper;
    com.spring5.mvc.rest.domain.Customer customer;
    CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {


    }

    @Test
    void customerToCustomerDTO() {
        //Given
        customerDTO =new CustomerDTO();
        customerDTO.setFirstName(FIRST_NAME);
        customerDTO.setLastName("Paracha");
        customerDTO.setId(1L);
        customerDTO.setCustomerURL("/customer/"+1L);
        //when(CustomerMapper.INSTANCE.customerDTOToCustomer(any())).thenReturn(customer);
        //When
        com.spring5.mvc.rest.domain.Customer customer1 = CustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);

        //Then
        assertNotNull(customer1);
        assertEquals(customer1.getFirstName(), FIRST_NAME);
    }

    @Test
    void customerDTOToCustomer() {
        //Given
        customer =new com.spring5.mvc.rest.domain.Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName("Paracha");
        customer.setId(1L);
        customer.setCustomerURL("/customer/"+1L);
        //when(CustomerMapper.INSTANCE.customerToCustomerDTO(any())).thenReturn(customerDTO);
        //When
        CustomerDTO customer1 = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);

        //Then
        assertNotNull(customer1);
        assertEquals(customer1.getFirstName(), FIRST_NAME);
    }
}