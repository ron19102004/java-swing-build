package com.movie.app.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordBCrypt {

    public PasswordBCrypt() {
    }

    public String encode(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verify(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
