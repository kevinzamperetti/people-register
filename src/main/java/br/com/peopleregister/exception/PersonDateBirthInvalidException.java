package br.com.peopleregister.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class PersonDateBirthInvalidException extends RuntimeException {
    public PersonDateBirthInvalidException(String message) {
        super(message);
    }
}
