package jv.service.Impl;

import jv.dao.OrderProductDAO;
import jv.entity.OrderProduct;
import jv.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 30.07.2017.
 */
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductDAO orderProductDAO;

    public void save(OrderProduct orderProduct) {
        orderProductDAO.save(orderProduct);
    }

    public OrderProduct findOne(int id) {
        return orderProductDAO.findOne(id);
    }

    public List<OrderProduct> findAll() {
        return orderProductDAO.findAll();
    }

    public void delete(int id) {
        orderProductDAO.delete(id);
    }
}
