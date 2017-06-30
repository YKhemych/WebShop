package jv.dao;

import jv.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 25.06.2017.
 */

public interface CategoryDAO extends JpaRepository<Category, Integer> {
}
