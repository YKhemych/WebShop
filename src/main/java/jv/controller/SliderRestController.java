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

    @PostMapping("/changeNameSlide-{id}")
    public void changeNameSlide(@PathVariable("id") int id, @RequestBody String name){
        stockSliderService.changeNewNameSlide(id, name);
    }

    @DeleteMapping("/deleteSlide-{id}")
    public void deleteSlide(@PathVariable("id")int deleteId){
        stockSliderService.delete(deleteId);
    }

    @GetMapping("/allSlide")
    public List<StockSlider> allSlide(){
        return stockSliderService.findAll();
    }



}
