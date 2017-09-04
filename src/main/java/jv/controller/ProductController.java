package jv.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import jv.entity.Category;
import jv.entity.Comment;
import jv.entity.Photo;
import jv.entity.Product;
import jv.entity.listProducts.*;
import jv.service.CategoryService;
import jv.service.CommentService;
import jv.service.PhotoService;
import jv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.DTD;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 16.08.2017.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

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

    @GetMapping("/productWithId{id}")
    public String getProductWithId(@PathVariable("id") int id, Model model){
        Product buff = productService.findOne(id);
        System.out.println(buff.getClass());
        List<Comment> comment = new ArrayList<Comment>(commentService.findAllByProduct(buff));
//        System.out.println(comment);
        model.addAttribute("DTYPE", buff.getClass());
        model.addAttribute("product", buff);
        model.addAttribute("pictures", photoService.findAllWhereProduct(buff));
        model.addAttribute("comments",  commentService.findAllByProduct(buff));

        return "productPage";
    }

    @GetMapping("/product-{name}")
    public String getProduct(@PathVariable("name") String name, Model model){
        Product product = productService.findByName(name);
        model.addAttribute("product", product);
        model.addAttribute("pictures", photoService.findAllWhereProduct(product));

        return "productPage";
    }

    public void savePhoto(@RequestParam List<MultipartFile> productPictureList, Product product) throws IOException {
        for (MultipartFile productPicture: productPictureList) {
            String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
            productPicture.transferTo(new File(realPath + productPicture.getOriginalFilename()));
            Photo photo = Photo
                    .builder()
                    .picture("/picture/" + productPicture.getOriginalFilename())
                    .product(product)
                    .build();
            photoService.save(photo);
        }
    }

    @PostMapping("/saveProduct{dtype}ToCategory{id}")
    public String saveProduct(@RequestParam List<MultipartFile> productPictureList,
                              @RequestParam String productName, @RequestParam String productMaker,
                              @RequestParam int productPrice, @RequestParam String productColor,
                              @RequestParam String productSize,  @RequestParam String productMaterial,
                              @RequestParam String productType,  @RequestParam String productDescription,
                              @PathVariable("dtype")String dType, @PathVariable("id")int categoryId) throws IOException {
        Category category = categoryService.findOne(categoryId);
        Product buffProduct = new Product();
        if (dType.equals("Bag")){
            Product product = new Bag(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        } else if(dType.equals("Gloves")){
            Product product = new Gloves(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        } else if (dType.equals("Wallet")){
            Product product = new Wallet(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        }else if (dType.equals("Wristband")){
            Product product = new Wristband(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        }else if (dType.equals("Scarf")){
            Product product = new Scarf(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        }else if (dType.equals("Hat")){
            Product product = new Hat(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType , category);
            productService.save(product);
            buffProduct = product;
        }else if (dType.equals("Strap")) {
            Product product = new Strap(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType, category);
            productService.save(product);
            buffProduct = product;
        }
//        System.out.println(productMaker);
//        System.out.println(productDescription);
        savePhoto(productPictureList, buffProduct);
        return "redirect:/productsWithCategory-" + categoryId ;
    }

    @PostMapping("/saveProductSunGlassToCategory{id}")
    public String saveProductSunGlass(@RequestParam List<MultipartFile> productPictureList,
                                      @RequestParam String productName, @RequestParam String productMaker,
                                      @RequestParam int productPrice, @RequestParam String productColor,
                                      @RequestParam String productSize,  @RequestParam String productMaterial,
                                      @RequestParam String productType,  @RequestParam String productDescription,
                                      @RequestParam String productColorLeans, @RequestParam String productProtectionLevel,
                                      @PathVariable("id")int categoryId) throws IOException {
        Category category = categoryService.findOne(categoryId);
        SunGlass product = new SunGlass(productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType, productColorLeans, productProtectionLevel, category);
        productService.save(product);
        savePhoto(productPictureList, product);
        return "redirect:/productsWithCategory-" + categoryId ;
    }

    @PostMapping("/saveProductClockToCategory{id}")
    public String saveProduct(@RequestParam List<MultipartFile> productPictureList,
                              @RequestParam String productName, @RequestParam String productMaker,
                              @RequestParam int productPrice, @RequestParam String productColor,
                              @RequestParam String productSize,  @RequestParam String productMaterial,
                              @RequestParam String productType,  @RequestParam String productDescription,
                              @RequestParam String productMechanism, @RequestParam String productGlass,
                              @RequestParam String productDialType, @RequestParam String productWaterResistance,
                              @PathVariable("id")int categoryId) throws IOException {
        Category category = categoryService.findOne(categoryId);
        Clock product = new Clock (productName, productPrice, productMaker, productSize, productColor, productMaterial, productDescription, productType, productMechanism, productGlass, productDialType, productWaterResistance, category);
        productService.save(product);
        savePhoto(productPictureList, product);
        return "redirect:/productsWithCategory-" + categoryId ;
    }





}
