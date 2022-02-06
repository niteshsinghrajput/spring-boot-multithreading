package com.nitesh.springbootmultithreading.controllers;

import com.nitesh.springbootmultithreading.entities.User;
import com.nitesh.springbootmultithreading.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("users")
    public ResponseEntity saveUsers(@RequestParam("file")MultipartFile[] files) throws Exception {
        for(MultipartFile file: files) {
            service.saveUser(file);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("users")
    public CompletableFuture<List<User>> getUsers() {
        return service.findAll();
    }
}
