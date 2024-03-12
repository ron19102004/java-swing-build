package com.movie.app.auths;

import com.movie.app.interfaces.UserDetails;

public class UsernamePasswordAuthentication {

    private String username;
    private String password;

    private UsernamePasswordAuthentication() {
    }
    public UsernamePasswordAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UsernamePasswordAuthentication(UserDetails details) {
        this.password = details.getPassword();
        this.username = details.getUsername();
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
}
