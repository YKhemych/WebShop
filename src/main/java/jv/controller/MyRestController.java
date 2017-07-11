package jv.controller;

import jv.entity.Category;
import jv.entity.User;
import jv.service.CategoryService;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 03.07.2017.
 */
@RestController
public class MyRestController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User jsonUser) {
        userService.save(jsonUser);
    }

    @Autowired
    CategoryService categoryService;

    @PostMapping("/saveCategory")
    public void saveCategory(@RequestBody Category jsonCategory){
        System.out.println("hello");
        categoryService.save(jsonCategory);
    }



}
