package com.siddhraj.supermarket.service.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhraj.supermarket.service.user.entity.UserRole;
import com.siddhraj.supermarket.service.user.model.UserRoleModel;
import com.siddhraj.supermarket.service.user.service.UserRoleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
@RestController
@RequestMapping("/api/user")
@Tag(name = "User Role", description = "User Role API") 
public class UserRoleController {
    
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/{userId}/user-role")
    public ResponseEntity<UserRole> getUserRoleByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userRoleService.getUserRoleByUserId(userId));
    }

    @PostMapping("/{userId}/user-role")
    public ResponseEntity<UserRole> saveUserRole(@PathVariable Long userId, @RequestBody UserRoleModel userRoleModel) {
        return ResponseEntity.ok(userRoleService.saveUserRole(userRoleModel));
    }

    @DeleteMapping("/{userId}/user-role/{userRoleId}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long userRoleId) {
        userRoleService.deleteUserRole(userRoleId);
        return ResponseEntity.ok().build();
    }
}
