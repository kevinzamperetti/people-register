package br.com.peopleregister.service.impl;

import br.com.peopleregister.entity.Person;
import br.com.peopleregister.exception.*;
import br.com.peopleregister.repository.PersonRepository;
import br.com.peopleregister.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static br.com.peopleregister.util.ValidateUtil.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public List<Person> listAll() {
        return repository.findAll(Sort.by("name"));
    }

    @Override
    public Person findById(Long id) {
        if (isNull(id)) {
            throw new PersonIdNotProvidedException("Id Not Provided.");
        }
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person Not Found."));
    }

    @Override
    public Person save(Person person) {
        checkFields(person);
        person.setCreatedAt(LocalDateTime.now());
        return repository.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        if (id != person.getId()) {
            throw new PersonIdDifferentException("Different Id in Payload and Path.");
        }
        Person personDb = findById(id);
        checkFields(person);
        person.setCreatedAt(personDb.getCreatedAt());
        person.setUpdatedAt(LocalDateTime.now());
        return repository.save(person);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private void checkFields(Person person) {
        if (!hasText(person.getName())) {
            throw new PersonNameNotProvidedException("Name Not Provided.");
        }
        if (isNull(person.getDateBirth())) {
            throw new PersonDateBirthNotProvidedException("Date of Birth Not Provided.");
        }
        if (isNull(person.getCpf())) {
            throw new PersonCpfNotProvidedException("CPF Not Provided.");
        }
        checkEmail(person.getEmail());
        checkDateBirth(person.getDateBirth());
        checkCpf(person);
    }

    private void checkDateBirth(String date) {
        if (nonNull(date) && !validateDate(date)) {
            throw new PersonDateBirthInvalidException("Invalid Date of Birth.");
        }
    }

    private void checkCpf(Person person) {
        if (!validateCpf(person.getCpf())) {
            throw new PersonCpfInvalidException("Invalid CPF.");
        }
        repository.findByCpf(person.getCpf())
                .ifPresent(personDb -> {
                    if (personDb.getId() != person.getId() || isNull(personDb.getId())) {
                        throw new PersonCpfAlreadyExistsException("CPF Already Exists.");
                    }
                });
    }

    private void checkEmail(String email) {
        if (nonNull(email) && !validateEmail(email)) {
            throw new PersonEmailInvalidException("Invalid Email.");
        }
    }

}
