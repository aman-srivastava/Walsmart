package com.aman.controller;

import com.aman.model.User;
import com.aman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by asriva26 on 04/25/18.
 */

@Controller
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public String usersList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return user.getUserId().toString();
    }
}
