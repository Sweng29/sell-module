package com.sell.module.controller;

import com.sell.module.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category)
    {
        System.out.println(category.getCategoryId()+" "+category.getName());

        return ResponseEntity.ok(category);
    }

    @GetMapping(value = "/category/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable @Min(1) Long id)
    {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Category>  updateCategory(@PathVariable @Min(1) Long id,@Valid @RequestBody Category category)
    {
        if(id==null)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable @Min(1) Long id)
    {
        if(id==null)
        {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
