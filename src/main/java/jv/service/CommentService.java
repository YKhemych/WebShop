package jv.service;

import jv.entity.Comment;
import jv.entity.Product;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface CommentService {
    void save(Comment comment);
    void delete(int id);
    Comment findOne(int id);
    List<Comment> findAll();
    List<Comment> findAllByProduct(Product product);
}
