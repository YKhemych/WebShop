package jv.dao;

import jv.entity.Category;
import jv.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("from Product p left join fetch p.photos where p.category = :category group by p.id")
    List<Product> findAllWithCategoryId(@Param("category") Category category);

    @Query("from Product p where p.name = :name")
    Product findByName(@Param("name") String name);

    @Query("from Product p left join fetch p.photos where p.id = :id group by p.id")
    Product findOneWithPhoto(@Param("id") int id);
}
