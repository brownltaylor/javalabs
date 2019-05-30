package com.brown.personinfo.controller;

import com.brown.personinfo.domain.Person;
import com.brown.personinfo.repository.PersonRepository;
import com.brown.personinfo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class PersonController {

    @Autowired
    private PersonService personService;



    @GetMapping(value = "/people")
    public Iterable<Person> getAllRecords() {
        Iterable<Person> people = personService.getAll();
        return people;
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<?> getPersonRecord(@PathVariable Long id) {
        Optional<Person> person = personService.getOne(id);
        return new ResponseEntity<>(person, HttpStatus.OK);

    }


    @PostMapping(value = "/people/createRecord")
    public ResponseEntity<?> createPersonRecord(@RequestBody Person person) {
        personService.create(person);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPersonUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();
        responseHeaders.setLocation(newPersonUri);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<?> deleteRecord(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @PutMapping(value = "/people/{id}")
    public ResponseEntity<?> updateRecord(@PathVariable Long id, @RequestBody Person person) {
        personService.update(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);

    }

    @PostMapping(value="/people/createRecords")
    public ResponseEntity<?> createAllRecords(@RequestBody Iterable<Person> people){
        personService.createAll(people);

        return new ResponseEntity<>(people, HttpStatus.CREATED);
    }
}
