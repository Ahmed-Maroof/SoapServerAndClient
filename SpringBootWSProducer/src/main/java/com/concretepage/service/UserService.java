package com.concretepage.service;

import com.concretepage.entity.User;
import com.concretepage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User getUserById(Long id) {
         return userRepository.findOne(id);
    }

    @Override
    public User checkUserNameAndPassword(String username, String password) {

        if(userRepository.existsByUsername(username))
        {
           Optional<User> user =  userRepository.findByUsername(username);
           if( user.get().getPassword().equals(password))
           {
                return user.get();
           }else{
               return null;
           }
        }else
        {
          return null;
        }

    }
}
