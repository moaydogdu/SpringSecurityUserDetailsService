package com.moaydogdu.ssexample2.service;

import com.moaydogdu.ssexample2.model.entity.User;
import com.moaydogdu.ssexample2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {
        User user =
                userRepository
                        .findUserByUsername(username)
                        .orElseThrow(
                                ()-> new UsernameNotFoundException("User not found."));

        return new SecurityUser(user);
    }
}
