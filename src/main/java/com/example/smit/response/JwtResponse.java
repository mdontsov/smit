package com.example.smit.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(String accessToken,
                       String username,
                       Collection<? extends GrantedAuthority> authorities) {
        this.token = accessToken;
        this.username = username;
        this.authorities = authorities;
    }

    public JwtResponse(String token,
                       String username,
                       String password,
                       String fullname,
                       String phone,
                       Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
