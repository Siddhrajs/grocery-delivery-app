package com.siddhraj.supermarket.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhraj.supermarket.service.user.entity.UserPreference;
import com.siddhraj.supermarket.service.user.service.UserPreferenceService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Preference", description = "User Preference API")
public class UserPreferenceController {

    @Autowired
    private UserPreferenceService userPreferenceService;

    @GetMapping("/{userId}/user-preference")
    public ResponseEntity<List<UserPreference>> getUserPreferencesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userPreferenceService.getUserPreferencesByUserId(userId));
    }

    @PostMapping("/{userId}/user-preference")
    public ResponseEntity<UserPreference> saveUserPreference(@PathVariable Long userId, @RequestBody UserPreference userPreference) {
        return ResponseEntity.ok(userPreferenceService.saveUserPreference(userPreference));
    }

    @DeleteMapping("/{userId}/user-preference/{userPreferenceId}")
    public ResponseEntity<Void> deleteUserPreference(@PathVariable Long userPreferenceId) {
        userPreferenceService.deleteUserPreference(userPreferenceId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/user-preference/{preferenceName}")
    public ResponseEntity<String> getPreferenceValueByUserIdAndPreferenceName(@PathVariable Long userId, @PathVariable String preferenceName) {
        return ResponseEntity.ok(userPreferenceService.getPreferenceValueByUserIdAndPreferenceName(userId, preferenceName));
    }    
}
