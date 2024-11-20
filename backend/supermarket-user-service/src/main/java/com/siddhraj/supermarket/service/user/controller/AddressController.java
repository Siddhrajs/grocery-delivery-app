package com.siddhraj.supermarket.service.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddhraj.supermarket.service.user.entity.Address;
import com.siddhraj.supermarket.service.user.service.AddressService;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Address", description = "Address API")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

    @GetMapping("/{userId}/address")
    public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(addressService.getAddressesByUserId(userId));
    }

    @PostMapping("/{userId}/address")
    public ResponseEntity<Address> saveAddress(@PathVariable Long userId, @RequestBody Address address) {
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    @DeleteMapping("/{userId}/address/{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/address/{addressId}")
    public ResponseEntity<Address> setDefaultAddress(@PathVariable Long addressId) throws Exception {
        return ResponseEntity.ok(addressService.setDefaultAddress(addressId));
    }
}
