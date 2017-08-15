package jv.service.listProduct;

import jv.entity.listProducts.Clock;
import jv.service.ProductService;

import java.util.List;

/**
 * Created by user on 14.08.2017.
 */
public interface ClockService{
    void save(Clock product);
    Clock findOne(int id);
    List<Clock> findAll();
}
