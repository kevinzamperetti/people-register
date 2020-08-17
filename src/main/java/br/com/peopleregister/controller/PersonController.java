package br.com.peopleregister.controller;

import br.com.peopleregister.entity.Person;
import br.com.peopleregister.entity.dto.PersonDTO;
import br.com.peopleregister.service.PersonService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin
@RestController
@Api(value = "Person")
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService service;

    @GetMapping
    public ResponseEntity<List<Person>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> listById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(CREATED).body(service.save(personDTO.transformsToObject()));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Person> update(@PathVariable(value = "id") Long id, @RequestBody PersonDTO personDTO) {
        return ResponseEntity.status(ACCEPTED).body(service.update(id, personDTO.transformsToObject()));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
