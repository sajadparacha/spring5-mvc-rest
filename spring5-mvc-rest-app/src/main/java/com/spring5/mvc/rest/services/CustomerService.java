package com.spring5.mvc.rest.services;

//import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.model.CustomerDTO;
import com.spring5.mvc.rest.domain.Customer;

import java.util.List;

public interface CustomerService {
    public List<CustomerDTO> getAllCustomers();
//    public CustomerDTO getCustomerById(Long id);
    public CustomerDTO getCustomerByFirstName(String name);

    public CustomerDTO getCustomerById(Long id);

    public CustomerDTO saveCustomer(CustomerDTO customerDTO);
    public CustomerDTO updateCustomer(Long id,CustomerDTO customerDTO);
    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);
}
