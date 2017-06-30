package jv.service.Impl;

import jv.dao.CategoryDAO;
import jv.entity.Category;
import jv.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 25.06.2017.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    public void save(Category category) {
        categoryDAO.save(category);
    }

    public Category findOne(int id) {
        return categoryDAO.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }
}
