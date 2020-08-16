package br.com.peopleregister.service.impl;

import br.com.peopleregister.entity.Person;
import br.com.peopleregister.exception.*;
import br.com.peopleregister.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl service;

    @Mock
    private PersonRepository repository;

    @Test(expected = PersonIdNotProvidedException.class)
    public void personIdNotProvidedExceptionWhenFindById() {
        service.findById(null);
    }

    @Test(expected = PersonNameNotProvidedException.class)
    public void personIdNotProvidedExceptionWhenSave() {
        Person person = createPerson();
        person.setName(null);
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonDateBirthNotProvidedException.class)
    public void personDateBirthNotProvidedExceptionWhenSave() {
        Person person = createPerson();
        person.setDateBirth(null);
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonCpfNotProvidedException.class)
    public void personCpfNotProvidedExceptionWhenSave() {
        Person person = createPerson();
        person.setCpf(null);
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonEmailInvalidException.class)
    public void personEmailInvalidExceptionWhenSave() {
        Person person = createPerson();
        person.setEmail("teste.com");
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonEmailAlreadyExistsException.class)
    public void personEmailAlreadyExistsExceptionWhenSave() {
        Person person = createPerson();
        Person person2 = createPerson();
        person2.setId(2L);

        Person returnSave = service.save(person);

        doReturn(Optional.of(person)).when(repository).findByEmail(person.getEmail());

        Person returnSave2 = service.save(person2);

        verify(repository, times(1)).save(returnSave);
        verify(repository, times(0)).save(returnSave2);
    }

    @Test(expected = PersonDateBirthInvalidException.class)
    public void personDateBirthInvalidExceptionWhenSave() {
        Person person = createPerson();
        person.setDateBirth("12/13/1980");
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonCpfInvalidException.class)
    public void personCpfInvalidExceptionWhenSave() {
        Person person = createPerson();
        person.setCpf("12345678900");
        service.save(person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonCpfAlreadyExistsException.class)
    public void personCpfAlreadyExistsExceptionWhenSave() {
        Person person = createPerson();
        Person person2 = createPerson();
        person2.setId(2L);

        Person returnSave = service.save(person);

        doReturn(Optional.of(person)).when(repository).findByCpf(person.getCpf());

        Person returnSave2 = service.save(person2);

        verify(repository, times(1)).save(returnSave);
        verify(repository, times(0)).save(returnSave2);
    }

    @Test(expected = PersonIdDifferentException.class)
    public void personIdDifferentExceptionWhenUpdate() {
        Long idPath = 2L;
        Person person = createPerson();
        service.update(idPath, person);
        verify(repository, times(0)).save(person);
    }

    @Test(expected = PersonNameNotProvidedException.class)
    public void personIdNotProvidedExceptionWhenUpdate() {
        Person person = createPerson();
        person.setName(null);
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonDateBirthNotProvidedException.class)
    public void personDateBirthNotProvidedExceptionWhenUpdate() {
        Person person = createPerson();
        person.setDateBirth(null);
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonCpfNotProvidedException.class)
    public void personCpfNotProvidedExceptionWhenUpdate() {
        Person person = createPerson();
        person.setCpf(null);
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonEmailInvalidException.class)
    public void personEmailInvalidExceptionWhenUpdate() {
        Person person = createPerson();
        person.setEmail("teste.com");
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonEmailAlreadyExistsException.class)
    public void personEmailAlreadyExistsExceptionWhenUpdate() {
        Person person = createPerson();
        Person person2 = createPerson();
        person2.setId(2L);
        person2.setEmail("person2@teste.com");
        person2.setCpf("34001042053");

        Person returnSave = service.save(person);
        Person returnSave2 = service.save(person2);

        doReturn(Optional.of(person)).when(repository).findById(person2.getId());
        doReturn(Optional.of(person)).when(repository).findByEmail(person.getEmail());

        person2.setEmail(person.getEmail());
        Person returnEdit2 = service.update(person2.getId(), person2);

        verify(repository, times(1)).save(returnSave);
        verify(repository, times(1)).save(returnSave2);
        verify(repository, times(0)).save(returnEdit2);
    }

    @Test(expected = PersonDateBirthInvalidException.class)
    public void personDateBirthInvalidExceptionWhenUpdate() {
        Person person = createPerson();
        person.setDateBirth("12/13/1980");
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonCpfInvalidException.class)
    public void personCpfInvalidExceptionWhenUpdate() {
        Person person = createPerson();
        person.setCpf("12345678900");
        service.save(person);
        service.update(person.getId(), person);
        verify(repository, times(1)).save(person);
    }

    @Test(expected = PersonCpfAlreadyExistsException.class)
    public void personCpfAlreadyExistsExceptionWhenUpdate() {
        Person person = createPerson();
        Person person2 = createPerson();
        person2.setId(2L);
        person2.setEmail("person2@teste.com");
        person2.setCpf("34001042053");

        Person returnSave = service.save(person);
        Person returnSave2 = service.save(person2);

        doReturn(Optional.of(person)).when(repository).findById(person2.getId());
        doReturn(Optional.of(person)).when(repository).findByCpf(person.getCpf());

        person2.setCpf(person.getCpf());
        Person returnEdit2 = service.update(person2.getId(), person2);

        verify(repository, times(1)).save(returnSave);
        verify(repository, times(1)).save(returnSave2);
        verify(repository, times(0)).save(returnEdit2);
    }

    private Person createPerson() {
        return  Person.builder()
                .id(1L)
                .name("Person")
                .gender("M")
                .email("person@teste.com.br")
                .dateBirth("01/01/2000")
                .naturalFrom("Porto Alegre")
                .nationality("Brasileiro")
                .cpf("02738734073")
                .build();
    }

}
