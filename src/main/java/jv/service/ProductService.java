package jv.service;

import jv.entity.Category;
import jv.entity.Product;
import jv.entity.listProducts.Strap;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductService {
    void save(Product product);
    Product findOne(int id);
    Product findOneWithPhoto(int id);
    Product findByName(String name);
    List<Product> findAll();
    List<Product> findAllWithCategoryId(Category category);
}
