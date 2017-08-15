package jv.controller;

import jv.entity.Category;
import jv.entity.Product;
import jv.entity.User;
import jv.service.CategoryService;
import jv.service.ProductService;
import jv.service.StockSliderService;
import jv.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;


@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StockSliderService stockSliderService;
    @Autowired
    private ProductService productService;


    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("stockSliders", stockSliderService.findAll());
//        logger.trace("url is : /");
//        logger.debug("debug method work");
//        logger.info("was created model with name stockSliders");
//        logger.warn("warn warn");
//        logger.error("EROOORRORORORO!");
//        logger.fatal("FATALITY");
        return "index";
    }

    @GetMapping("/admin/adminPage")
    public String adminPage(Model model){
        return "adminPage";
    }

    @GetMapping("/user/userPage")
    public String userPage(){
        return "userPage";
    }


    @PostMapping("/asd")
    public String logMe() {
        return "redirect:/";
    }

    @GetMapping("/productsWithCategory-{id}")
    public String listProductsPage(@PathVariable("id")int id, Model model){
        Category fatherCategory= categoryService.findOne(id);
               List<Product> productList = new ArrayList<Product>(productService.findAllWithCategoryId(fatherCategory));


        List<Category> listCategoryFirstChild = new ArrayList<Category>(categoryService.findAllWithIdFatherCategory(fatherCategory.getId()));
        for (Category firstCategory: listCategoryFirstChild) {
            System.out.println(firstCategory.getId());
            List<Product> listProductFirstChild = new ArrayList<Product>(productService.findAllWithCategoryId(firstCategory));
            productList.addAll(listProductFirstChild);
            List<Category> listCategorySecondChild = new ArrayList<Category>(categoryService.findAllWithIdFatherCategory(firstCategory.getId()));
            for (Category secondCategory: listCategorySecondChild) {
                List<Product> listProductSecondChild = new ArrayList<Product>(productService.findAllWithCategoryId(secondCategory));
                productList.addAll(listProductSecondChild);
            }
        }

        model.addAttribute("fatherCategory" ,fatherCategory);
        model.addAttribute("productList", productList);

        return "listProductsPage";
    }

    @GetMapping("/admin/addProductToCategory-{id}")
    public String adminAddProduct(@PathVariable("id")int categoryId, Model model){
        model.addAttribute("categoryId", categoryId);
        return "addProduct";
    }

    @GetMapping("/productPage")
    public String productPage(Model model){
        return "productPage";
    }



}
