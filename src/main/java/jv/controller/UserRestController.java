package jv.controller;

import jv.entity.User;
import jv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
