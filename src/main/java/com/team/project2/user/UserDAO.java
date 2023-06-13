package com.team.project2.user;

import lombok.Data;

@Data
public class UserDAO {

    private String id;
    private String password;
    private String email;
    private String nickname;
    private String title;
    private String role;
    private boolean withdraw;
}
