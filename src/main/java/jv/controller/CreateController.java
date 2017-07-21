package jv.controller;

import jv.entity.StockSlider;
import jv.service.CategoryService;
import jv.service.StockSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 28.06.2017.
 */

@RequestMapping("/create/")
@Controller
public class CreateController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StockSliderService stockSliderService;


//    @PostMapping("/saveCategory")
//    public String saveCategory(@RequestParam String categoryName){
//        System.out.println("gffhjhk");
////        categoryService.save();
//        return "redirect:/admin/adminPage";
//    }


    @PostMapping("/saveStockSlide")
    public String saveBlog(@RequestParam String slideName,
                           @RequestParam MultipartFile picture
    ) throws IOException {

        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        picture.transferTo(new File(realPath + picture.getOriginalFilename()));
        StockSlider stockSlider = StockSlider
                .builder()
                .name(slideName)
                .picture("/picture/" + picture.getOriginalFilename())
                .build();
        stockSliderService.save(stockSlider);
        return "redirect:/admin/adminPage";
    }

}
