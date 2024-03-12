package com.movie.app.errors;

public class ApplicationConfigurationNoStartException extends RuntimeException {

    private final String message;

    public ApplicationConfigurationNoStartException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
