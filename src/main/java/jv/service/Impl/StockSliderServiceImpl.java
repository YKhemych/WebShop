package jv.service.Impl;

import jv.dao.StockSliderDAO;
import jv.entity.StockSlider;
import jv.service.StockSliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 05.07.2017.
 */
@Service
@Transactional
public class StockSliderServiceImpl implements StockSliderService {

    @Autowired
    StockSliderDAO stockSliderDAO;

    public void save(StockSlider stockSlider) {
        stockSliderDAO.save(stockSlider);
    }

    public void delete(int id) {
        stockSliderDAO.delete(id);
    }

    public void changeNewNameSlide(int id, String newName) {
        stockSliderDAO.changeNewNameSlide(id, newName);
    }

    public StockSlider findOne(int id) {
        return stockSliderDAO.findOne(id);
    }

    public List<StockSlider> findAll() {
        return stockSliderDAO.findAll();
    }
}
