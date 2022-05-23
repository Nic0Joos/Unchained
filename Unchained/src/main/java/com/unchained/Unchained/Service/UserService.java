package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.UnchainedUser;
import com.unchained.Unchained.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
// Author: Alex Herzog
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveUser(@Valid UnchainedUser unchainedUser) throws Exception {
        if (unchainedUser.getUserId() == null) {
            if (userRepository.findByEmail(unchainedUser.getEmail()) != null ) {
                throw new Exception("User email already exists!");
            }
        }
        unchainedUser.setPassword(passwordEncoder.encode(unchainedUser.getPassword()));
        userRepository.save(unchainedUser);
    }

    public UnchainedUser getCurrentUser() {
        String userEmail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userEmail);
    }
}
