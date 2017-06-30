package jv.service;

import jv.entity.Comment;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface CommentService {
    void save(Comment comment);
    Comment findOne(int id);
    List<Comment> findAll();
}
