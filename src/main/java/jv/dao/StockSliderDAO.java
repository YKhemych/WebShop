package jv.dao;

import jv.entity.StockSlider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 05.07.2017.
 */
public interface StockSliderDAO extends JpaRepository<StockSlider, Integer> {

    @Modifying
    @Query("update StockSlider ss set ss.name = :newName where ss.id = :idSlide")
    void changeNewNameSlide(@Param("idSlide")int id, @Param("newName")String newName);

}
