package jv.dao;

import jv.entity.Comment;
import jv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by user on 30.06.2017.
 */
public interface CommentDAO extends JpaRepository<Comment, Integer> {

    @Query("from Comment c left join fetch c.user where c.product = :product")
    List<Comment> findAllByProduct(@Param("product")Product product);
}
