package dev.destiny.marketplacebackend.controllers;

import dev.destiny.marketplacebackend.model.MPUser;
import dev.destiny.marketplacebackend.security.JwtUtil;
import dev.destiny.marketplacebackend.services.MPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authenticate")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MPUserService mpUserService;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("register")
    public MPUser register_new_user(@RequestBody MPUser user){
        return mpUserService.register_user((user));
    }



}
