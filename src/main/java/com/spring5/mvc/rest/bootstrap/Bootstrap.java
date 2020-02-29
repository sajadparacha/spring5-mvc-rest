package com.spring5.mvc.rest.bootstrap;

import com.spring5.mvc.rest.model.Category;
import com.spring5.mvc.rest.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
}
