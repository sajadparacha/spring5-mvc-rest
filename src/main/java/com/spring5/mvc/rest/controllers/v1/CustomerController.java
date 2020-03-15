package com.spring5.mvc.rest.controllers.v1;

import com.spring5.mvc.rest.api.v1.model.CustomerDTO;
import com.spring5.mvc.rest.api.v1.model.CustomerListDTO;
import com.spring5.mvc.rest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){
//        List<CustomerDTO> customers= customerService.getAllCustomers();
        /**
         * If we pass a list like above line the json will be off below format , not mentioning the name of the list whoch will become confusing
         * [
         *     {
         *         "id": 1,
         *         "firstName": "Sajjad",
         *         "lastName": "Paracha",
         *         "customerURL": "/customer/1"
         *     },
         *     {
         *         "id": 2,
         *         "firstName": "Waqar",
         *         "lastName": "Paracha",
         *         "customerURL": "/customer/2"
         *     },
         *     {
         *         "id": 3,
         *         "firstName": "Dilshad",
         *         "lastName": "Paracha",
         *         "customerURL": "/customer/3"
         *     }
         * ]
         *
         *
         * However if we create CustomerListDTO( object whihc holds rge same list ina customers variable the json will be in below format
         * Notice the customers name of the json object clearly identifying the objects in this list
         * {
         *     "customers": [
         *         {
         *             "id": 1,
         *             "firstName": "Sajjad",
         *             "lastName": "Paracha",
         *             "customerURL": "/customer/1"
         *         },
         *         {
         *             "id": 2,
         *             "firstName": "Waqar",
         *             "lastName": "Paracha",
         *             "customerURL": "/customer/2"
         *         },
         *         {
         *             "id": 3,
         *             "firstName": "Dilshad",
         *             "lastName": "Paracha",
         *             "customerURL": "/customer/3"
         *         }
         *     ]
         * }
         */
        return
                new ResponseEntity<CustomerListDTO>(
                        new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name){
        return
                new ResponseEntity<CustomerDTO>(
                        customerService.getCustomerByFirstName(name), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return
                new ResponseEntity<CustomerDTO>(
                        customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(customerService.saveCustomer(customerDTO),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id,customerDTO),HttpStatus.OK);
    }
}
