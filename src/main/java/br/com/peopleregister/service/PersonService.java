package br.com.peopleregister.service;

import br.com.peopleregister.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> listAll();

    Person findById(Long id);

    Person save(Person person);

    Person update(Long id, Person person);

    void delete(Long id);

}
