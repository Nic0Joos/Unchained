package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.User;
import com.unchained.Unchained.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveUser(@Valid User user) throws Exception {
        if (user.getUserId() == null) {
            if (userRepository.findByEmail(user.getEmail()) != null ) {
                throw new Exception("User email already exists!");
            }
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getCurrentUser() {
        String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userEmail);
    }

}
