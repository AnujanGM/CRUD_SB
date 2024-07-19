package com.crud.demo.service;

import com.crud.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(int id){
        Optional<User> user = userRepository.findById(id);
       if (user.isEmpty()){
           throw new RuntimeException("User not found to retrieve...");
       }
       return user.get();
    }

    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        Optional<User> dbUser = userRepository.findById(user.getId());
        if (dbUser.isEmpty()){
            throw new RuntimeException("User not found for Update...");
        }
        User exisitingUser = dbUser.get();
        exisitingUser.setUsername(user.getUsername());

        return userRepository.save(exisitingUser);
    }

    public void deleteUser(int id){
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isEmpty()){
            throw new RuntimeException("User not found for Delete...");
        }
        userRepository.delete(dbUser.get());
    }
    
}
