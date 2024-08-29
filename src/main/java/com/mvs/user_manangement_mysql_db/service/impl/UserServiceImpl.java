package com.mvs.user_manangement_mysql_db.service.impl;

import com.mvs.user_manangement_mysql_db.entity.User;
import com.mvs.user_manangement_mysql_db.repository.UserRepository;
import com.mvs.user_manangement_mysql_db.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    // In Spring 4.3 onwards we need not inject the dependencies
    // using @Autowired for constructor that has single instance
    // or single parameter
    // The @AllArgsConstructor is used to have the constructor
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long id) {
        User existingUser = getUserById(id);
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
