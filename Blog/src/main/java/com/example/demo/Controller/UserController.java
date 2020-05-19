package com.example.demo.Controller;

import com.example.demo.DAO.Article;
import com.example.demo.DAO.User;
import com.example.demo.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/test")
    public User getUserByUsername(@RequestBody User user ){

        return userRepository.findByUsername(user.getUsername());
    }

}
