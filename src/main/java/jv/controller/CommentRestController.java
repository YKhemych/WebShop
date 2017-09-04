package jv.controller;

import jv.entity.Comment;
import jv.entity.Product;
import jv.entity.User;
import jv.service.CommentService;
import jv.service.ProductService;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by user on 26.08.2017.
 */
@RestController
public class CommentRestController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @PostMapping("/saveCommentFrom{userName}To{productId}")
    void saveComment(@PathVariable("userName")String userName, @PathVariable("productId")int productId, @RequestBody String text){
        Date currentDate = new Date();
        Product product = productService.findOne(productId);
        User user = userService.findByName(userName);
        Comment comment = new Comment(user, product, currentDate, text);
        commentService.save(comment);
    }

    @DeleteMapping("/deleteComment{id}")
    void deleteComment(@PathVariable("id")int id){
        commentService.delete(id);
    }


}
