package com.atspickem.backend.controller;

import com.atspickem.backend.models.AuthenticationRequest;
import com.atspickem.backend.models.AuthenticationResponse;
import com.atspickem.backend.models.SignUpRequest;
import com.atspickem.backend.services.MyUserDetailsService;
import com.atspickem.backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException exc) {
            throw new Exception("Incorrect Username or Password", exc);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> createNewUser(@RequestBody SignUpRequest signUpRequest) throws Exception {

        try {
            myUserDetailsService.createNewUser(signUpRequest);
        } catch (Exception exc) {
            throw new Exception("Could not create user", exc);
        }
        return ResponseEntity.ok("User successfully created");
    }
}