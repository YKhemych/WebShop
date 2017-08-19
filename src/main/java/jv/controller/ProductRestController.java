package jv.controller;

import jv.entity.Category;
import jv.entity.OrderProduct;
import jv.entity.Product;
import jv.entity.User;
import jv.entity.listProducts.*;
import jv.service.CategoryService;
import jv.service.OrderProductService;
import jv.service.ProductService;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 14.08.2017.
 */
@RestController
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderProductService orderProductService;

    @PostMapping("/order-{nameUser}Product{productId}-{number}")
    public void saveOrderProduct(/*@RequestBody int numberOfProduct ,*/@PathVariable("number") int numberOfProduct,@PathVariable("nameUser")String name, @PathVariable("productId")int productId){
        User user = (User) userService.findByName(name);
        Product product = productService.findOne(productId);
        orderProductService.save(new OrderProduct(numberOfProduct, user, product));
    }



}
