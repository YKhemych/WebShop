package jv.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import jv.entity.*;
import jv.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private OrderProductService orderProductService;
    @Autowired
    private  PhotoService photoService;
    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("stockSliders", stockSliderService.findAll());
        List<OrderProduct> orderProductList = new ArrayList<OrderProduct>(orderProductService.findPopularOrder(new PageRequest(0, 12)));
        List<Product> popularProductList = new ArrayList<Product>();
        for (OrderProduct orderProduc:orderProductList) {
            List<Photo> photos = new ArrayList<Photo>();
            photos.add(photoService.findOneWhereProduct(orderProduc.getProduct()));
            orderProduc.getProduct().setPhotos(photos);
            popularProductList.add(orderProduc.getProduct());
        }
        model.addAttribute("popularProducts", popularProductList);

        List<Product> newProductList = new ArrayList<Product>(productService.findNewProduct(new PageRequest(0, 12)));
        model.addAttribute("newProducts", newProductList);

//        System.out.println(orderProductList);
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

    @GetMapping("/userPage")
    public String userPage(){
        return "userPage";
    }


    @PostMapping("/asd")
    public String logMe() {
        return "redirect:/";
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
