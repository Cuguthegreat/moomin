package com.example.moomin.exceptions;

import java.io.Serial;

public class MoominNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1;

    public MoominNotFoundException(String message) {
        super(message);
    }
}
