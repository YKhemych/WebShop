package jv.service;

import jv.entity.Photo;
import jv.entity.Product;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface PhotoService {
    void save(Photo photo);
    Photo findOne(int id);
    Photo findOneWhereProduct(Product product);
    List<Photo> findAllWhereProduct(Product product);
    List<Photo> findAll();
}
