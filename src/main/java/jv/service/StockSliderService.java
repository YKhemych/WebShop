package jv.service;

import jv.entity.StockSlider;

import java.util.List;

/**
 * Created by user on 05.07.2017.
 */
public interface StockSliderService {
    void save(StockSlider stockSlider);
    StockSlider findOne(int id);
    List<StockSlider> findAll();
}
