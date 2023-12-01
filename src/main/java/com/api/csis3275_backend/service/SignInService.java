package com.api.csis3275_backend.service;

import lombok.Getter;

@Getter
public class SignInService {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
