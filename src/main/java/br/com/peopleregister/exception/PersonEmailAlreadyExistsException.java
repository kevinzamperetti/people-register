package br.com.peopleregister.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(CONFLICT)
public class PersonEmailAlreadyExistsException extends RuntimeException {
    public PersonEmailAlreadyExistsException(String message) {
        super(message);
    }
}
