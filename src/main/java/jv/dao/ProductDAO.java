package jv.dao;

import jv.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {

//    @Query duct> findAllWithCategoryId(@Param("categoryId") int categoryId);
}
