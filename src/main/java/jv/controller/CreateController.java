package jv.controller;

import jv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by user on 28.06.2017.
 */

@RequestMapping("/create/")
@Controller
public class CreateController {

    @Autowired
    CategoryService categoryService;


    @PostMapping("saveCategory")
    public String saveCategory(@RequestParam String categoryname){
//        categoryService.save();
        return "redirect:/adminPage";
    }


}
