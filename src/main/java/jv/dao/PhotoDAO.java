package jv.dao;

import jv.entity.Photo;
import jv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface PhotoDAO extends JpaRepository<Photo, Integer> {

    @Query("from Photo p where p.product = :product")
    List<Photo> findAllWhereProduct(@Param("product") Product product);

    @Query("from Photo p where p.product = :product group by p.product ")
    Photo findOneWhereProduct(@Param("product") Product product);
}
