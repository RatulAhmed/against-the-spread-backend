package com.atspickem.backend.controller;

import com.atspickem.backend.models.AuthenticationRequest;
import com.atspickem.backend.models.AuthenticationResponse;
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
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    // Route that is available without authentication
//    @GetMapping("/")
//    public String hello()  {
//        return "<h2>Welcome</h2>";
//    }
//    // Test Route that is only accessible after authentication
//    @GetMapping("/test")
//    public String test()  {
//        return "<h2>Test Route</h2>";
//    }

//    @RequestMapping(value="/authenticate", method = RequestMethod.POST)
@PostMapping(value="/authenticate")
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException exc) {
            throw new Exception("Incorrect Username or Password", exc);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }



}
