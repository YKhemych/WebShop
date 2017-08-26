package jv.controller;

import jv.entity.Category;
import jv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by user on 03.07.2017.
 */
@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/saveCategory")
    public void saveCategory(@RequestBody Category jsonCategorySave){
        categoryService.save(jsonCategorySave);
    }

    @DeleteMapping("/deleteCategory-{id}")
    public void deleteCategory(@PathVariable("id")int deleteId){
        categoryService.delete(deleteId);
    }

    @GetMapping("/allCategory")
    public List<Category> allCategoryes(){
        return categoryService.findAll();
    }


    @PostMapping("/changeNameCategory")
    public void renameCategory(@RequestBody Category jsonCategoryRename){
        categoryService.renameCategory(jsonCategoryRename.getId(), jsonCategoryRename.getName());
    }

    @PostMapping("/changeIdFatherCategory")
    public void changeIdFatherCategory(@RequestBody Category jsonCategoryChangeIDFC){
        categoryService.changeIdFatherCategory(jsonCategoryChangeIDFC.getId(), jsonCategoryChangeIDFC.getIdFatherCategoryes());
    }

//    @GetMapping("/product")
//    public String getProduct(){
//        return "productsPage";
//    }


}
