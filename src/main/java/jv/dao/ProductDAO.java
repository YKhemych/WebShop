package jv.dao;

import jv.entity.Category;
import jv.entity.OrderProduct;
import jv.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {

    @Query("from Product p left join fetch p.photos where p.category = :category group by p.id ")
    List<Product> findAllWithCategoryId(@Param("category") Category category, Pageable pageRequest);

    @Query("from Product p where p.name = :name")
    Product findByName(@Param("name") String name);

    @Query("from Product p left join fetch p.photos where p.id = :id group by p.id")
    Product findOneWithPhoto(@Param("id") int id);

    @Query("from Product p left join fetch p.photos where p.orderProduct = :productOrder group by p.id")
    Product findOneByOrderProduct(@Param("productOrder")OrderProduct orderProduct);  //!!!!!!!!!!

    @Query("from Product p left join fetch p.photos order by p.id DESC")
    List<Product> findNewProduct(Pageable pageRequest);

    @Query("select count(p.id) from Product p where p.category = :category")
    int countProductByCategory(@Param("category") Category category);

    @Query("select p.id, p.name from Product p")
    List<Product> selectProduct();

}
