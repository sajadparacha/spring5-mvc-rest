package com.spring5.mvc.rest.repositories;

import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByFirstName(String name);
}
