package com.arielSoares.WebSystem.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 8941880552813196066L;

    public DatabaseException(String message) {
        super(message);
    }
}
