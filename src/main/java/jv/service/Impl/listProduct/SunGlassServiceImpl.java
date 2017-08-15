package jv.service.Impl.listProduct;

import jv.dao.listProduct.SunGlassDAO;
import jv.entity.listProducts.SunGlass;
import jv.service.listProduct.SunGlassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 14.08.2017.
 */
@Service
@Transactional
public class SunGlassServiceImpl implements SunGlassService {
    @Autowired
    SunGlassDAO sunGlassDAO;

    public void save(SunGlass product) {
        sunGlassDAO.save(product);
    }

    public SunGlass findOne(int id) {
        return sunGlassDAO.findOne(id);
    }

    public List<SunGlass> findAll() {
        return sunGlassDAO.findAll();
    }
}
