package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel extends AbstractModel implements Serializable {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private RoleModel role;
}
