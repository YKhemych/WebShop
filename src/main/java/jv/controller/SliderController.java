package jv.controller;

import jv.entity.Photo;
import jv.entity.Product;
import jv.entity.StockSlider;
import jv.service.CategoryService;
import jv.service.PhotoService;
import jv.service.ProductService;
import jv.service.StockSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 28.06.2017.
 */

@RequestMapping("/create/")
@Controller
public class SliderController {

    @Autowired
    private StockSliderService stockSliderService;
    @Autowired
    private PhotoService photoService;
    @Autowired
    private ProductService productService;


    @PostMapping("/saveStockSlide")
    public String saveBlog(@RequestParam String slideName,
                           @RequestParam MultipartFile slidePicture
    ) throws IOException {
        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        slidePicture.transferTo(new File(realPath + slidePicture.getOriginalFilename()));
        StockSlider stockSlider = StockSlider
                .builder()
                .name(slideName)
                .picture("/picture/" + slidePicture.getOriginalFilename())
                .build();
        stockSliderService.save(stockSlider);
        return "redirect:/admin/adminPage";
    }


}
