package jv.dao;

import jv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 30.06.2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer> {
}
