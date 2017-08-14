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

    public void delete(int id) {
        categoryDAO.delete(id);
    }

    public Category findOne(int id) {
        return categoryDAO.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public List<Category> findAllWithIdFatherCategory(int idFatherCategory) {
//        return categoryDAO.findAllWithIdFatherCategory(idFatherCategory);
        return null;
    }

    public void renameCategory(int id, String newName) {
        categoryDAO.renameCategory(id, newName);
    }

    public void changeIdFatherCategory(int id, int newIdFatherCategoryes) {
        categoryDAO.changeIdFatherCategory(id, newIdFatherCategoryes);
    }

}
