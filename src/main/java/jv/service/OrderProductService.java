package jv.service;

import jv.entity.OrderProduct;
import jv.entity.Product;
import jv.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * Created by user on 30.07.2017.
 */
public interface OrderProductService {
    void save(OrderProduct orderProduct);
    OrderProduct findOne(int id);
    OrderProduct findOneWithUserAndProduct(User user, Product product);
    List<OrderProduct> findAll();
    List<OrderProduct> selectAllWithProduct(User user);
    void delete(int id);
    void setReservedTrue(int id);
    List<OrderProduct> findPopularOrder(Pageable pageRequest);
}
