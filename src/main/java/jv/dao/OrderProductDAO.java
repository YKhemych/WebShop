package jv.dao;

import jv.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 30.07.2017.
 */
public interface OrderProductDAO extends JpaRepository<OrderProduct, Integer> {
}
