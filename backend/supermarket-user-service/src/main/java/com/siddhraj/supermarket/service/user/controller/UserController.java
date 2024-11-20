package com.siddhraj.supermarket.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhraj.supermarket.service.user.entity.User;
import com.siddhraj.supermarket.service.user.model.UserModel;
import com.siddhraj.supermarket.service.user.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User", description = "User API")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.saveUser(userModel));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.updateUser(userId, userModel));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteByUserId(@PathVariable Long userId) {
        userService.deleteByUserId(userId);
        return ResponseEntity.ok().build();
    }    
}
