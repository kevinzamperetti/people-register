package br.com.peopleregister.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class PersonIdNotProvidedException extends RuntimeException {
    public PersonIdNotProvidedException(String message) {
        super(message);
    }
}
