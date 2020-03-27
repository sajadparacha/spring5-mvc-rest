package com.spring5.mvc.rest.controllers.v1;

import com.spring5.mvc.rest.api.v1.model.CategoryDTO;
import com.spring5.mvc.rest.api.v1.model.CatorgoryListDTO;
import com.spring5.mvc.rest.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CatorgoryListDTO getallCatetories(){
        //We have to create CatorgoryListDTO here as we want to return back the JSON collection object
        return
                new CatorgoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return
                categoryService.getCategoryByName(name);
    }
}
