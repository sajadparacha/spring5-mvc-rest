package com.spring5.mvc.rest.api.v1.mapper;

import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class CustomerDTOMapperTest {
    CustomerMapper customerMapper;
    com.spring5.mvc.rest.domain.Customer customer;
    CustomerDTO customer2;
    @BeforeEach
    void setUp() {


    }

    @Test
    void customerToCustomerDTO() {
        //Given
        customer2 =new CustomerDTO();
        customer2.setFirstName("Sajjad");
        customer2.setLastName("Paracha");
        customer2.setId(1L);
        customer2.setCustomerURL("/customer/"+1L);
        //when(CustomerMapper.INSTANCE.customerDTOToCustomer(any())).thenReturn(customer);
        //When
        com.spring5.mvc.rest.domain.Customer customer1 = CustomerMapper.INSTANCE.customerDTOToCustomer(customer2);

        //Then
        assertNotNull(customer1);
        assertEquals(customer1.getFirstName(),"Sajjad");
    }

    @Test
    void customerDTOToCustomer() {
        //Given
        customer =new com.spring5.mvc.rest.domain.Customer();
        customer.setFirstName("Sajjad");
        customer.setLastName("Paracha");
        customer.setId(1L);
        customer.setCustomerURL("/customer/"+1L);
        //when(CustomerMapper.INSTANCE.customerToCustomerDTO(any())).thenReturn(customerDTO);
        //When
        CustomerDTO customer1 = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);

        //Then
        assertNotNull(customer1);
        assertEquals(customer1.getFirstName(),"Sajjad");
    }
}