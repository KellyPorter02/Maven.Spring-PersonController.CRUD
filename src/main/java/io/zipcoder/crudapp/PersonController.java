package io.zipcoder.crudapp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService service;


    public PersonController(PersonService service) {
        this.service = service;
    }

    // http://localhost:8080/people
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    // http://localhost:8080/people?
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    // http://localhost:8080/people?firstName=Kelly&lastName=Porter  ** will auto provide id
    // http://localhost:8080/people?id=1&firstName=Kelly&lastName=Porter ** will only
    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    // http://localhost:8080/people?
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, Person person) {
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    // http://localhost:8090/people/1?
    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}


