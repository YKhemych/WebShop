package jv.service.Impl.listProduct;

import jv.dao.listProduct.ClockDAO;
import jv.entity.listProducts.Clock;
import jv.service.listProduct.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 14.08.2017.
 */
@Service
@Transactional
public class ClockServiceImpl implements ClockService {
    @Autowired
    ClockDAO clockDAO;

    public void save(Clock product) {
        clockDAO.save(product);
    }

    public Clock findOne(int id) {
        return clockDAO.findOne(id);
    }

    public List<Clock> findAll() {
        return clockDAO.findAll();
    }
}
