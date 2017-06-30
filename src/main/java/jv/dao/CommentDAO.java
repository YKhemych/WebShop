package jv.dao;

import jv.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 30.06.2017.
 */
public interface CommentDAO extends JpaRepository<Comment, Integer> {
}
