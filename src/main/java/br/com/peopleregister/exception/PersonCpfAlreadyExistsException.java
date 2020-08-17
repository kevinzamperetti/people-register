package br.com.peopleregister.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(CONFLICT)
public class PersonCpfAlreadyExistsException extends RuntimeException {
    public PersonCpfAlreadyExistsException(String message) {
        super(message);
    }
}
