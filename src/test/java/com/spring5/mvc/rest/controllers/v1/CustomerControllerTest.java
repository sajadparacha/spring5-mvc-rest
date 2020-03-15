package com.spring5.mvc.rest.controllers.v1;


import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.mvc.rest.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
class CustomerControllerTest extends AbstractRestControllerTest {
    public static final String NAME = "Sajjad";
    public static final String LAST_NAME = "Paracha";
    public static final long ID = 1L;
    @Mock
    CustomerService customerService;
    MockMvc mockMvc;

    @InjectMocks
    CustomerController  customerController;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void getAllCustomers() throws Exception {
        //Given
        CustomerDTO customer =new CustomerDTO();
        customer.setFirstName("Sajjad");
        customer.setLastName(LAST_NAME);
        customer.setId(ID);
        customer.setCustomerURL("/customer/"+ ID);
        CustomerDTO customer1 =new CustomerDTO();
        customer1.setFirstName("Waqar");
        customer1.setLastName(LAST_NAME);
        customer1.setId(2L);
        customer1.setCustomerURL("/customer/"+2L);

//        Customer customer=new Customer();
//        customer.setFirstName("Sajjad");
//        customer.setLastName("Paracha");
//        customer.setId(1L);
//        customer.setCustomerURL("/customer/"+1L);
        List<CustomerDTO> customerList =new ArrayList();
        customerList.add(customer);
        customerList.add(customer1);

        when(customerService.getAllCustomers()).thenReturn(customerList);
        //When
        mockMvc.perform(get("/api/v1/customers/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(2)));

        //Then
    }

    @Test
    void getCustomerByFirstName() throws Exception {
        //given
        CustomerDTO customer =new CustomerDTO();
        customer.setFirstName(NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(ID);
        customer.setCustomerURL("/customer/"+NAME);
        when(customerService.getCustomerByFirstName(any())).thenReturn(customer);
        //when
        mockMvc.perform(get("/api/v1/customers/"+NAME)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",equalTo(NAME)));
        //then
    }

    @Test
    void getCustomerById() throws Exception {
        //given
        CustomerDTO customer =new CustomerDTO();
        customer.setFirstName(NAME);
        customer.setLastName(LAST_NAME);
        customer.setId(ID);
        customer.setCustomerURL("/customer/1");
        when(customerService.getCustomerById(any())).thenReturn(customer);
        //when
        mockMvc.perform(get("/api/v1/customers/id/1")
                .contentType(MediaType.APPLICATION_JSON))
        //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",equalTo(NAME)));

    }

    @Test
    void saveCustomer() throws Exception {
        //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName(NAME);
        customer.setLastName(LAST_NAME);

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customer.getFirstName());
        returnDTO.setLastName(customer.getLastName());
        returnDTO.setCustomerURL("/api/v1/customers/1");

        when(customerService.saveCustomer(customer)).thenReturn(returnDTO);
        System.out.println(asJsonString(customer));
        //when/then
        mockMvc.perform(post("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", equalTo(NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1")));
    }

    @Test
    void getCustomerByName() {
    }

    @Test
    void updateCustomer() throws Exception {
        //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName(NAME);
        customer.setLastName(LAST_NAME);
        customer.setCustomerURL("/api/v1/customers/1");

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customer.getFirstName());
        returnDTO.setLastName(customer.getLastName());
        returnDTO.setCustomerURL("/api/v1/customers/1");

        when(customerService.updateCustomer(ID,customer)).thenReturn(returnDTO);
        System.out.println(asJsonString(customer));
        //when/then
        mockMvc.perform(put("/api/v1/customers/"+ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo(NAME)))
                .andExpect(jsonPath("$.customer_url", equalTo("/api/v1/customers/1")));

    }
}