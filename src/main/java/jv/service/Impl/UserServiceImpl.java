package jv.service.Impl;

import jv.dao.UserDAO;
import jv.entity.User;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 29.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    public User findByName(String name) {
        return userDAO.findByName(name);
    }

    public User findByNameWithOrder(String name) {
        return userDAO.findByNameWithOrder(name);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username);
    }

    public void editDeliveryAddress(String username, String name, String surname, String country, String city, String street, int zipCode, String phone) {
        userDAO.editDeliveryAddress(username, name, surname, country, city, street, zipCode, phone);
    }
}
