package jv.dao;

import jv.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by user on 29.06.2017.
 */
public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.name = :newName, u.surname= :newSurname, u.country= :newCountry, u.city= :newCity," +
            " u.street= :newStreet, u.zipCode= :newZipCode, u.phone= :newPhone where u.username = :oldUserName")
    void editDeliveryAddress(@Param("oldUserName")String username, @Param("newName")String name, @Param("newSurname")String surname,
                             @Param("newCountry")String country, @Param("newCity")String city, @Param("newStreet")String street,
                             @Param("newZipCode")int zipCode, @Param("newPhone")String phone);


    @Query("from User u where u.username = :name")
    User findByName(@Param("name") String name);

    @Query("from User u left join fetch u.orderProducts where u.username = :name")
    User findByNameWithOrder(@Param("name") String name);

    @Modifying
    @Query("update User u set u.email = :email where u.username = :userName")
    void editEmailAddress(@Param("userName")String userName, @Param("email")String email);

}
