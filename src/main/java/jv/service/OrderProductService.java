package jv.service;

import jv.entity.OrderProduct;

import java.util.List;

/**
 * Created by user on 30.07.2017.
 */
public interface OrderProductService {
    void save(OrderProduct orderProduct);
    OrderProduct findOne(int id);
    List<OrderProduct> findAll();
    void delete(int id);
}
