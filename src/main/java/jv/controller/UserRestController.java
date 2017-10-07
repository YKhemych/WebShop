package jv.controller;

import jv.entity.User;
import jv.service.MailService;
import jv.service.UserService;
import jv.service.validators.UserRegValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by user on 24.07.2017.
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserRegValidator userRegValidator;

    @InitBinder("user")
    public void bind(WebDataBinder binder){
        binder.addValidators(userRegValidator);
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()){
            return result.getFieldError().getField();
        } else {
            userService.save(user);
            return null;
        }

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

    @PostMapping("/editEmail-{userLogin}")
    public void editEmailAddress(@PathVariable("userLogin")String userLogin, @RequestBody String email){
//        System.out.println(userLogin);
//        System.out.println(email);
        userService.editEmailAddress(userLogin, email);
    }

    @PostMapping("/sendConfirmationCodeOn-{email}")
    public void sendConfirmationCode(@PathVariable("email")String email, @RequestBody String code){
//        System.out.println(code);
//        System.out.println(email);
        String message = "Hello my friend you want change your password. It is your confirmation code :"  + code;
        mailService.sendByEmail(email, message);
    }
}
