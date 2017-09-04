package jv.service.Impl;

import jv.dao.CommentDAO;
import jv.entity.Comment;
import jv.entity.Product;
import jv.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDAO commentDAO;

    public void save(Comment comment) {
        commentDAO.save(comment);
    }

    public void delete(int id) {
        commentDAO.delete(id);
    }

    public Comment findOne(int id) {
        return commentDAO.findOne(id);
    }

    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    public List<Comment> findAllByProduct(Product product) {
        return commentDAO.findAllByProduct(product);
    }
}
