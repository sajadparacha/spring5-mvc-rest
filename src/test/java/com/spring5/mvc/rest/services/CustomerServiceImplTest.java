package com.spring5.mvc.rest.services;

import com.spring5.mvc.rest.api.v1.mapper.CustomerMapper;
import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.mvc.rest.domain.Customer;
import com.spring5.mvc.rest.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {
    public static final String FIRST_NAME = "Sajjad";
    public static final long CUSTOMER_ID = 1L;
    public static final String LAST_NAME = "Paracha";
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;
    CustomerService customerService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService=new CustomerServiceImpl(customerRepository,CustomerMapper.INSTANCE);
    }

    @Test
    void getAllCustomers() {
        //Given
        com.spring5.mvc.rest.domain.Customer customer =new com.spring5.mvc.rest.domain.Customer();
        customer.setFirstName("Sajjad");
        customer.setLastName(LAST_NAME);
        customer.setId(CUSTOMER_ID);
        customer.setCustomerURL("/customer/"+ CUSTOMER_ID);
        com.spring5.mvc.rest.domain.Customer customer1 =new com.spring5.mvc.rest.domain.Customer();
        customer1.setFirstName("Waqar");
        customer1.setLastName(LAST_NAME);
        customer1.setId(2L);
        customer1.setCustomerURL("/customer/"+2L);

//        Customer customer=new Customer();
//        customer.setFirstName("Sajjad");
//        customer.setLastName("Paracha");
//        customer.setId(1L);
//        customer.setCustomerURL("/customer/"+1L);
          List<com.spring5.mvc.rest.domain.Customer> customerList =new ArrayList();
          customerList.add(customer);
          customerList.add(customer1);
          when(customerRepository.findAll()).thenReturn(customerList);
//        when(categoryRepository.findAll()).thenReturn(categoryList);

        //When
        List<CustomerDTO> customers = customerService.getAllCustomers();
        //Then
        assertNotNull(customers);
        assertEquals(customers.size(),2);
        assertEquals(customers.get(0).getFirstName(),"Sajjad");
    }

    @Test
    void getCustomerByFirstName() {
        //Given
        Customer customer =new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(CUSTOMER_ID);
//        Optional<Customer> optionalCustomer=Optional.of(customer);
        when(customerRepository.findByFirstName(any())).thenReturn(customer);
        //When
        CustomerDTO customerDTO=customerService.getCustomerByFirstName(FIRST_NAME);
        //Then
        assertNotNull(customerDTO);
        assertEquals(customerDTO.getFirstName(),FIRST_NAME);
    }



    @Test
    void getCustomerById() {
        //Given
        Customer customer =new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(CUSTOMER_ID);
        Optional<Customer> optionalCustomer=Optional.of(customer);
        when(customerRepository.findById(any())).thenReturn(optionalCustomer);
        //When
        CustomerDTO customerDTO=customerService.getCustomerById(CUSTOMER_ID);
        //Then
        assertNotNull(customerDTO);
        assertEquals(customerDTO.getFirstName(),FIRST_NAME);

    }

    @Test
    void saveCustomer() {
        //Given
        Customer customer =new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(CUSTOMER_ID);

        CustomerDTO customerDTO1 =new CustomerDTO();
        customerDTO1.setFirstName(FIRST_NAME);
        customerDTO1.setLastName(LAST_NAME);
        customerDTO1.setId(CUSTOMER_ID);

        when(customerRepository.save(any())).thenReturn(customer);

        //When
        CustomerDTO customerDTO= customerService.saveCustomer(customerDTO1);
        //Then
        assertNotNull(customerDTO);
        assertEquals(customerDTO.getFirstName(),FIRST_NAME);
    }

    @Test
    void updateCustomer() {
        //Given
        Customer customer =new Customer();
        customer.setFirstName(FIRST_NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(CUSTOMER_ID);
        CustomerDTO customerDTO1 =new CustomerDTO();
        customerDTO1.setFirstName(FIRST_NAME);
        customerDTO1.setLastName(LAST_NAME);
        customerDTO1.setId(CUSTOMER_ID);
        when(customerRepository.save(any())).thenReturn(customer);

        //When
        CustomerDTO customerDTO= customerService.updateCustomer(CUSTOMER_ID,customerDTO1);
        //Then
        assertNotNull(customerDTO);
        assertEquals(customerDTO.getFirstName(),FIRST_NAME);
    }
}