package com.movie.app.configs;

import com.movie.app.auths.AuthenticationManager;
import com.movie.app.configs.db.DatabaseConfiguration;
import com.movie.app.entities.UserEntity;
import com.movie.app.errors.ApplicationConfigurationNoStartException;
import com.movie.app.interfaces.UserDetailsService;
import com.movie.app.utils.PasswordBCrypt;

public final class ApplicationConfiguration {

    private static ApplicationConfiguration INSTANCE;

    public static ApplicationConfiguration getInstance() {
        if (INSTANCE == null) {
            throw new ApplicationConfigurationNoStartException("Application configuration no start ! Pls start application with: ApplicationConfiguration.start();");
        }
        return INSTANCE;
    }

    public static void start() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationConfiguration();
            INSTANCE.databaseBuilder();
        }
    }

    private ApplicationConfiguration() {
    }

    /*<-Configs->*/
    public DatabaseConfiguration databaseConfiguration() {
        return DatabaseConfiguration.config("localhost", 3306, "root", "", "java_movie_prj");
    }

    private void databaseBuilder() {
        this.databaseConfiguration()
                .addEntity(UserEntity.SQL)
                .buildEntity();
    }

    public UserDetailsService detailsService() {
        return (username) -> {
            return null;
        };
    }

    public PasswordBCrypt passwordBCrypt() {
        return new PasswordBCrypt();
    }

    public AuthenticationManager authenticationManager() {
        return AuthenticationManager.getInstance();
    }
}
