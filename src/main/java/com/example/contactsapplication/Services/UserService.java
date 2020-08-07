package com.example.contactsapplication.Services;

import com.example.contactsapplication.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User editUser(User user1) {
        User user = userRepository.getOne(user1.getId());
        user.setName(user1.getName());
        user.setEmail(user1.getEmail());
        user.setActive(user1.getActive());
        return userRepository.save(user);

    }

    public void deleteUser(Integer id) { userRepository.deleteById(id); }
}
