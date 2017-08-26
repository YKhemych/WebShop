package jv.controller;

import jv.entity.User;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by user on 24.07.2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User jsonUser) {
        userService.save(jsonUser);
    }

    @PostMapping("/editDeliveryAddress")
    public void editDeliveryAddress(@RequestBody User jsonUserEdit){
        userService.editDeliveryAddress(jsonUserEdit.getUsername(), jsonUserEdit.getName(), jsonUserEdit.getSurname(),
                jsonUserEdit.getCountry(), jsonUserEdit.getCity(), jsonUserEdit.getStreet(), jsonUserEdit.getZipCode(),
                jsonUserEdit.getPhone());
    }

    @GetMapping("/user{userName}")
    public User findUser(@PathVariable("userName")String userName){
        User user = userService.findByNameWithOrder(userName);
        return user;
    }
}
