package com.movie.app.auths;

import com.movie.app.configs.ApplicationConfiguration;
import com.movie.app.interfaces.UserDetails;
import com.movie.app.interfaces.UserDetailsService;
import com.movie.app.utils.PasswordBCrypt;

public class AuthenticationManager {

    private final PasswordBCrypt passwordBCrypt;
    private final UserDetailsService detailsService;
    private static AuthenticationManager INSTANCE;

    private AuthenticationManager() {
        this.passwordBCrypt = ApplicationConfiguration.getInstance().passwordBCrypt();
        this.detailsService = ApplicationConfiguration.getInstance().detailsService();
    }

    public static AuthenticationManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AuthenticationManager();
        }
        return INSTANCE;
    }

    public boolean authenticate(UsernamePasswordAuthentication authentication) {
        UserDetails details = this.detailsService.findUserDetailsByUsername(authentication.getUsername());
        return this.passwordBCrypt.verify(authentication.getPassword(), details.getPassword());
    }
}
