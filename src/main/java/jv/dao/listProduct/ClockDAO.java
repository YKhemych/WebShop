package jv.dao.listProduct;

import jv.entity.listProducts.Clock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 14.08.2017.
 */
public interface ClockDAO extends JpaRepository<Clock, Integer> {
}
