package com.mvs.mysql.demo;

import com.mvs.mysql.demo.db_setup.UserEntity;
import com.mvs.mysql.demo.db_setup.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    UserRepository userRepository;
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String getUserByName(@RequestParam String name){

        UserEntity user = userRepository.findByName(name);

        return user.toString();
    }
}
