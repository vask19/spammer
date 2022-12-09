package com.example.spammer.model;

import com.example.spammer.enums.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    private int id;
    private Role role;
    private String username;
    private String email;
    private String password;

    private boolean active;


    private List<String> emails;
}
