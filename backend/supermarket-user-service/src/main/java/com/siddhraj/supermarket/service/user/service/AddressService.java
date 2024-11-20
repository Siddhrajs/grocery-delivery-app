package com.siddhraj.supermarket.service.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddhraj.supermarket.service.user.entity.Address;
import com.siddhraj.supermarket.service.user.repository.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddressesByUserId(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public Address setDefaultAddress(Long addressId) throws Exception {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException("Address not found"));
        address.setIsDefault(true);
        return addressRepository.save(address);
    }
}
