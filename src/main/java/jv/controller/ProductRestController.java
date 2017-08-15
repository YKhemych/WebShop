package jv.controller;

import jv.entity.Category;
import jv.entity.listProducts.*;
import jv.service.CategoryService;
import jv.service.ProductService;
import jv.service.listProduct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 14.08.2017.
 */
@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;
    @Autowired
    SunGlassService sunGlassService;
    @Autowired
    ClockService clockService;
    @Autowired
    CategoryService categoryService;

    @PostMapping("/saveProductBagToCategory-{id}")
    public void saveProductBag(@PathVariable("id") int id, @RequestBody Bag jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductClockToCategory-{id}")
    public void saveProductClock(@PathVariable("id") int id, @RequestBody Clock jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        clockService.save(jsonProduct);
    }
    @PostMapping("/saveProductGlovesToCategory-{id}")
    public void saveProductGloves(@PathVariable("id") int id, @RequestBody Gloves jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductHatToCategory-{id}")
    public void saveProductHat(@PathVariable("id") int id, @RequestBody Hat jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductScarfToCategory-{id}")
    public void saveProductScarf(@PathVariable("id") int id, @RequestBody Scarf jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductStrapToCategory-{id}")
    public void saveProductStrap(@PathVariable("id") int id, @RequestBody Strap jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductSunGlassToCategory-{id}")
    public void saveProductSunGlass(@PathVariable("id") int id, @RequestBody SunGlass jsonProduct){
        System.out.println(jsonProduct);
        jsonProduct.setCategory(categoryService.findOne(id));
        sunGlassService.save(jsonProduct);
    }
    @PostMapping("/saveProductWalletToCategory-{id}")
    public void saveProductWallet(@PathVariable("id") int id, @RequestBody Wallet jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }
    @PostMapping("/saveProductWristbandToCategory-{id}")
    public void saveProductWristband(@PathVariable("id") int id, @RequestBody Wristband jsonProduct){
        jsonProduct.setCategory(categoryService.findOne(id));
        productService.save(jsonProduct);
    }

}
