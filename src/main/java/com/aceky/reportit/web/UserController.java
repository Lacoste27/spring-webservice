package com.aceky.reportit.web;

import java.util.List;

import com.aceky.reportit.data.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<?> allUser() {
        List<com.aceky.reportit.data.models.User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
