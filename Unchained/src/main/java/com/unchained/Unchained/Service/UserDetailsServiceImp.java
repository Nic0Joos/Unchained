package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.UnchainedUser;
import com.unchained.Unchained.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

//Author: Kaan
@Service
public class UserDetailsServiceImp implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UnchainedUser unchainedUser = userRepository.findByEmail(username);
        if (unchainedUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(unchainedUser.getEmail(), unchainedUser.getPassword(), emptyList());
    }

}
