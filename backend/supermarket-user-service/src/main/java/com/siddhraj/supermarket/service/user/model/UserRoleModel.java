package com.siddhraj.supermarket.service.user.model;

import lombok.Data;

@Data
public class UserRoleModel {
    private String roleName;
    private Long userId;
    private Long createdBy;
    private Long updatedBy;
}
