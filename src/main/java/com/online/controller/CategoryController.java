package com.online.controller;

import com.online.model.Category;
import com.online.model.User;
import com.online.service.CategoryService;
import com.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;


    @PostMapping("/admin/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @RequestHeader("Authorization") String jwt ) throws Exception {

        User user =userService.findUserByJwtToken(jwt);

        Category createdCategory=categoryService.createCategory(category.getName(),user.getId());

        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);


    }
    @GetMapping("/shop")
    public ResponseEntity<List<Category>> getShopCategory(
            @RequestHeader("Authorization") String jwt ) throws Exception {

        User user =userService.findUserByJwtToken(jwt);

        List<Category> categories=categoryService.findCategoryByShopId(user.getId());

        return new ResponseEntity<>(categories, HttpStatus.OK);


    }
}
