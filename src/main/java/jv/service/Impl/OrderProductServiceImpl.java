package jv.service.Impl;

import jv.dao.OrderProductDAO;
import jv.entity.OrderProduct;
import jv.entity.Product;
import jv.entity.User;
import jv.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 30.07.2017.
 */
@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductDAO orderProductDAO;

    public void save(OrderProduct orderProduct) {
        orderProductDAO.save(orderProduct);
    }

    public OrderProduct findOne(int id) {
        return orderProductDAO.findOne(id);
    }

    public OrderProduct findOneWithUserAndProduct(User user, Product product) {
        return orderProductDAO.findOneWithUserAndProduct(user, product);
    }

    public List<OrderProduct> findAll() {
        return orderProductDAO.findAll();
    }

    public List<OrderProduct> selectAllWithProduct(User user) {
        return orderProductDAO.selectAllWithProduct(user);
    }

    public void delete(int id) {
        orderProductDAO.delete(id);
    }

    public void setReservedTrue(int id) {
        orderProductDAO.setReservedTrue(id);
    }
}
