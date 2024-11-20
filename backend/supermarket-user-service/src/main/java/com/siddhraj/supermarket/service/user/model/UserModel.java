package com.siddhraj.supermarket.service.user.model;

import java.sql.Date;

import lombok.Data;

@Data
public class UserModel {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private String profilePictureUrl;
}
