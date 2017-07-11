package jv.dao;

import jv.entity.StockSlider;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 05.07.2017.
 */
public interface StockSliderDAO extends JpaRepository<StockSlider, Integer> {
}
