package jv.service;

import jv.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by user on 29.06.2017.
 */

public interface UserService {
    void save(User user);
    User findOne(int id);
    List<User> findAll();
    public UserDetails loadUserByUsername(String username);
}
