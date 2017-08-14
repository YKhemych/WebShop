package jv.service;

import jv.entity.Product;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductService {
    void save(Product product);
    Product findOne(int id);
    List<Product> findAll();
    List<Product> findAllWithCategoryId(int categoryId);
}
