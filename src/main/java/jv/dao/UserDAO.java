package jv.dao;

import jv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by user on 29.06.2017.
 */
public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
