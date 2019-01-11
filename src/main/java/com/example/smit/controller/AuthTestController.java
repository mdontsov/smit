package com.example.smit.controller;

import com.example.smit.model.User;
import com.example.smit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthTestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/test/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/test/smit")
    @PreAuthorize("hasRole('SMIT') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Project Management Board";
    }

    @GetMapping("/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @GetMapping("/test/userDetails")
    @PreAuthorize("hasRole('USER') or hasRole('SMIT') or hasRole('ADMIN')")
    Set<User> getUser() {
        return userRepository.getUser();
    }
}
