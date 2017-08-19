package jv.service.Impl;

import jv.dao.PhotoDAO;
import jv.entity.Photo;
import jv.entity.Product;
import jv.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoDAO photoDAO;

    public void save(Photo photo) {
        photoDAO.save(photo);
    }

    public Photo findOne(int id) {
        return photoDAO.findOne(id);
    }

    public List<Photo> findAllWhereProduct(Product product) {
        return photoDAO.findAllWhereProduct(product);
    }

    public List<Photo> findAll() {
        return photoDAO.findAll();
    }
}
