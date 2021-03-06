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
    User findByName(String name);
    User findByNameWithOrder(String name);
    List<User> findAll();
    public UserDetails loadUserByUsername(String username);
    void editDeliveryAddress(String username, String name, String surname, String country,
                             String city, String street, int zipCode, String phone);
    void editEmailAddress(String userName, String email);
}
