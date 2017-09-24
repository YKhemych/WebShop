package jv.service;

import jv.entity.Category;
import jv.entity.OrderProduct;
import jv.entity.Product;
import jv.entity.listProducts.Strap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductService {
    void save(Product product);
    void delete(int id);
    Product findOne(int id);
    Product findOneWithPhoto(int id);
    Product findByName(String name);
    List<Product> findAll();
    List<Product> findNewProduct(Pageable pageRequest);
    List<Product> findAllWithCategoryId(Category category, Pageable pageRequest);
    int countProductByCategory(Category category);
    List<Product> selectProduct();
}
