package br.com.viniciussouza.spring_boot_rest_api.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {

    public ExceptionResponse(String message, String details) {
        this(new Date(), message, details);
    }

    public ExceptionResponse(String message) {
        this(new Date(), message, null);
    }
}
