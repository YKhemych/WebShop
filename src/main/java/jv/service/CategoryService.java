package jv.service;

import jv.entity.Category;

import java.util.List;

/**
 * Created by user on 25.06.2017.
 */
public interface CategoryService {
    void save(Category category);
    Category findOne(int id);
    List<Category> findAll();
    List<Category> findAllWithIdFatherCategory(int idFatherCategory);
    void renameCategory(int id, String newName);
    void changeIdFatherCategory(int id, int newIdFatherCategoryes);
    void delete(int id);
}
