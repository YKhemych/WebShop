package jv.controller;

import jv.entity.*;
import jv.entity.listProducts.*;
import jv.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private PhotoService photoService;

    @DeleteMapping("/deleteProduct{id}")
    public void deleteProduct(@PathVariable("id")int id){
        productService.delete(id);
    }

    @PostMapping("/order-{nameUser}Product{productId}-{number}")
    public void saveOrderProduct(@PathVariable("number") int numberOfProduct,@PathVariable("nameUser")String name, @PathVariable("productId")int productId){
        User user = userService.findByName(name);
        Product product = productService.findOne(productId);
        OrderProduct buffOrderProduct = orderProductService.findOneWithUserAndProduct(user, product);
        if (buffOrderProduct == null){
            orderProductService.save(new OrderProduct(numberOfProduct, user, product));
        }

    }

    @GetMapping("/allProductWithOrder{userName}")
    public List<Product> allOrderWithProduct(@PathVariable("userName")String name){
        User user = userService.findByName(name);
        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>(orderProductService.selectAllWithProduct(user));
        List<Product> productList = new ArrayList<Product>();
        for (OrderProduct productOrder: orderProducts) {
            productList.add(productService.findOne(productOrder.getProduct().getId()));
        }
        return productList;
    }

    @GetMapping("/photoProduct{id}")
    public Photo productPhoto(@PathVariable("id")int id){
        Product product = productService.findOneWithPhoto(id);
        Photo photo = product.getPhotos().get(0);
        return photoService.findOneWhereProduct(product);
    }

    @GetMapping("/orderWithProduct{id}User{userName}")
    public OrderProduct orderProductWithProductAndUser(@PathVariable("id")int id, @PathVariable("userName")String userName){
        Product product = productService.findOne(id);
        User user = userService.findByName(userName);
        return orderProductService.findOneWithUserAndProduct(user, product);
    }

    @DeleteMapping("/deleteOrder{id}")
    public void deleteOrder(@PathVariable("id")int id){
        orderProductService.delete(id);
    }

    @PostMapping("/order{id}ReservedTrue")
    public void setReservedTrue(@PathVariable("id")int id){
        orderProductService.setReservedTrue(id);
    }

    @GetMapping("/allProduct")
    public List<Product> allProduct(){
        List<Product> productList = new ArrayList<Product>(productService.selectProduct());
        System.out.println("allProduct to Select");
        return productList;
    }



}
