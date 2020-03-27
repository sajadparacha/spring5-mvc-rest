package com.spring5.mvc.rest.services;

import com.spring5.model.CustomerDTO;
import com.spring5.mvc.rest.api.v1.mapper.CustomerMapper;
//import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.mvc.rest.domain.Customer;
import com.spring5.mvc.rest.exceptions.ResourceNotFoundException;
import com.spring5.mvc.rest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }



    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
//        return  categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto)
//                .collect(Collectors.toList());

    }

//    @Override
//    public CustomerDTO getCustomerById(Long id) {
//        Optional<com.spring5.mvc.rest.domain.Customer> customer = customerRepository.findById(id);
//        if(customer.isPresent()) {
//          return  customerMapper.customerToCustomerDTO(customer.get());
//        }
//        return null;
//    }

    @Override
    public CustomerDTO getCustomerByFirstName(String name) {
        Customer customer = customerRepository.findByFirstName(name);
        if(customer!=null)
            return  customerMapper.customerToCustomerDTO(customer);
        else
            throw new ResourceNotFoundException();
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        //**Have to write safe code here where we should check if the customer object is present or not
        if(customer.isPresent()){
        return  customerMapper.customerToCustomerDTO(customer.get());
        }
        throw new ResourceNotFoundException();

    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return saveOrUpdate(customerMapper.customerDTOToCustomer(customerDTO));
    }

    private CustomerDTO saveOrUpdate(Customer customer) {
        //Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer customerSaved=customerRepository.save(customer);
        if(customerSaved!=null) {
            return customerMapper.customerToCustomerDTO(customerSaved);
        }
        else
            throw new ResourceNotFoundException("Customer Was Not Saved/Updated Successfully");
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer=customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);

        return saveOrUpdate(customer);
    }
    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if(customerDTO.getFirstName() != null && !customerDTO.getFirstName().equals("")){
                customer.setFirstName(customerDTO.getFirstName());
            }

            if(customerDTO.getLastName() != null && !customerDTO.getLastName().equals("")){
                customer.setLastName(customerDTO.getLastName());
            }

            CustomerDTO returnDto = customerMapper.customerToCustomerDTO(customerRepository.save(customer));

            returnDto.setCustomerURL("/api/v1/customers/id/" + id);

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
    }
}
