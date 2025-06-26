package br.com.viniciussouza.spring_boot_rest_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequiredObjectIsNullException extends RuntimeException {

    public RequiredObjectIsNullException(String message) {
        super(message);
    }

    public RequiredObjectIsNullException() {
        super("It is not allowed to persist a null object!");
    }
}
