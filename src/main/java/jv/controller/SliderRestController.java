package jv.controller;

import jv.entity.StockSlider;
import jv.service.StockSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 24.07.2017.
 */
@RestController
public class SliderRestController {

    @Autowired
    private StockSliderService stockSliderService;

    @PostMapping("/saveSlide-{name}")//?????????????
    public void saveSlide(@PathVariable("name") String slideName, @RequestParam MultipartFile picture) throws IOException{
//        String realPath = System.getProperty("user.home") + File.separator + "images" + File.separator;
//        picture.transferTo(new File(realPath + picture.getOriginalFilename()));
//        StockSlider stockSlider = StockSlider
//                .builder()
//                .name(slideName)
//                .picture("/picture/" + picture.getOriginalFilename())
//                .build();
//        System.out.println("DSGfgnhjk.");
//        System.out.println();
//        stockSliderService.save(stockSlider);
    }

    @DeleteMapping("/deleteSlide-{id}")
    public void deleteSlide(@PathVariable("id")int deleteId){
//        System.out.println("hello delete");
//        System.out.println(deleteId);
        stockSliderService.delete(deleteId);
    }

    @GetMapping("/allSlide")
    public List<StockSlider> allSlide(){
        return stockSliderService.findAll();
    }



}
