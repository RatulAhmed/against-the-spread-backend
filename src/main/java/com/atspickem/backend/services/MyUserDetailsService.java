package com.atspickem.backend.services;


import com.atspickem.backend.dao.UserDAO;
import com.atspickem.backend.models.SignUpRequest;
import com.atspickem.backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userDAO.findByUsername(username));

        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));

        return user.map(MyUserDetails::new).get();
    }
    //TODO Encrypt Passwords
    public void createNewUser(SignUpRequest signUpRequest) {
        userDAO.save(new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getEmail()));
    }

}
