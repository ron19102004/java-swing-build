package com.movie.app;

import com.movie.app.configs.ApplicationConfiguration;
import com.movie.app.errors.ApplicationConfigurationNoStartException;

public class Application {

    public static void main(String[] args) {
        try {
            ApplicationConfiguration.start();
        } catch (ApplicationConfigurationNoStartException e) {
            System.out.println(e);
        }
    }
}
