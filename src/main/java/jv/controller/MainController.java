package jv.controller;

import jv.entity.User;
import jv.service.CategoryService;
import jv.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private UserService userService;
    Logger logger = Logger.getLogger(MainController.class);

    @GetMapping("/")
    public String index(Model model/*, @RequestParam String username*/){
        model.addAttribute("categorys", categoryService.findAll());
//        model.addAttribute("user", userService.loadUserByUsername(username));
        logger.trace("url is : /");
        logger.debug("debug method work");
        logger.info("was created model with name xxx");
        logger.warn("warn warn");
        logger.error("EROOORRORORORO!");
        logger.fatal("FATALITY");
        return "index";
    }

    @GetMapping("/admin/adminPage")
    public String adminPage(Model model){
        model.addAttribute("categorys", categoryService.findAll());
        return "adminPage";
    }

    @GetMapping("/user/userPage")
    public String userPage(){
        return "userPage";
    }


    @PostMapping("/asd")
    public String logMe() {
        System.out.println("fghjksdg");
        return "index";
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(user.isEnabled());
        userService.save(user);

        return "index";
    }




}
