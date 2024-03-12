
package com.movie.app.interfaces;

public interface UserDetailsService {
    public UserDetails findUserDetailsByUsername(String username);
}
