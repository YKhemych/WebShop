package jv.service.listProduct;


import jv.entity.listProducts.SunGlass;

import java.util.List;

/**
 * Created by user on 14.08.2017.
 */
public interface SunGlassService {
    void save(SunGlass product);
    SunGlass findOne(int id);
    List<SunGlass> findAll();
}
