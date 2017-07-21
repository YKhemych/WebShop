package jv.controller;

import jv.entity.Category;
import jv.entity.User;
import jv.service.CategoryService;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 03.07.2017.
 */
@RestController
public class MyRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User jsonUser) {
        userService.save(jsonUser);
    }

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/saveCategory")
    public void saveCategory(@RequestBody Category jsonCategorySave){
//        System.out.println("hello");
        categoryService.save(jsonCategorySave);
    }

    @DeleteMapping("/deleteCategory-{id}")
    public void deleteCategory(@PathVariable("id")int deleteId){
        System.out.println("hello delete");
        System.out.println(deleteId);
        categoryService.delete(deleteId);
    }

    @GetMapping("/allCategory")
    public List<Category> allCategoryes(){
        return categoryService.findAll();
    }


    @PostMapping("/changeNameCategory")//!!!!
    public void renameCategory(@RequestBody Category jsonCategoryRename){
        System.out.println("rename hellow");
        categoryService.renameCategory(jsonCategoryRename.getId(), jsonCategoryRename.getName());
    }

    @PostMapping("/changeIdFatherCategory")//!!!!!!
    public void changeIdFatherCategory(@RequestBody Category jsonCategoryChangeIDFC){
        System.out.println("change IDFC hellow");
//        categoryService.changeIdFatherCategory(jsonCategoryChangeIDFC.getId(), jsonCategoryChangeIDFC.getIdFatherCategoryes());
    }

}
