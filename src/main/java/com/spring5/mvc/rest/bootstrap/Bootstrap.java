package com.spring5.mvc.rest.bootstrap;

import com.spring5.mvc.rest.domain.Category;
import com.spring5.mvc.rest.domain.Customer;
import com.spring5.mvc.rest.repositories.CategoryRepository;
import com.spring5.mvc.rest.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    CategoryRepository categoryRepository;
    CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

//    public Bootstrap(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
        prepareCategories();
        prepareCustomers();
    }

    private void prepareCategories() {
        Category fruites= new Category();
        fruites.setName("fruites");

        Category fresh= new Category();
        fresh.setName("fresh");
        Category dried= new Category();
        dried.setName("dried");
        Category exotic= new Category();
        exotic.setName("exotic");
        Category nuts= new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruites);
        categoryRepository.save(fresh);
        categoryRepository.save(dried);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        log.debug("Categories loaded "+categoryRepository.count());
    }
    private void prepareCustomers() {
        Customer customer=new Customer();
        customer.setFirstName("Sajjad");
        customer.setLastName("Paracha");
        customer.setId(1L);
        customer.setCustomerURL("/customer/"+1L);

        Customer customer1=new Customer();
        customer1.setFirstName("Waqar");
        customer1.setLastName("Paracha");
        customer1.setId(2L);
        customer1.setCustomerURL("/customer/"+2L);

        Customer customer2=new Customer();
        customer2.setFirstName("Dilshad");
        customer2.setLastName("Paracha");
        customer2.setId(3L);
        customer2.setCustomerURL("/customer/"+3L);

        customerRepository.save(customer);

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        log.debug("Customers loaded "+customerRepository.count());
    }
}
