package jv.service.Impl;

import jv.dao.ProductDAO;
import jv.entity.Category;
import jv.entity.Product;
import jv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    public void save(Product product) {
        productDAO.save(product);
    }

    public Product findOne(int id) {
        return productDAO.findOne(id);
    }

    public Product findByName(String name) {
        return productDAO.findByName(name);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public List<Product> findAllWithCategoryId(Category category) {
        return productDAO.findAllWithCategoryId(category);
    }

}
