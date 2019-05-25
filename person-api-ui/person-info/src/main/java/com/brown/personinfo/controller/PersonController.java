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
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/people", method = RequestMethod.GET)
    @CrossOrigin(origins="http://localhost:4200")
    public Iterable<Person> getAllRecords() {
        Iterable<Person> people = personService.getAll();
        return people;
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonRecord(@PathVariable Long id) {
        Optional<Person> person = personService.getOne(id);
        return new ResponseEntity<>(person, HttpStatus.OK);

    }

    @RequestMapping(value = "/people/createRecord", method = RequestMethod.POST)
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

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecord(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateRecord(@PathVariable Long id, @RequestBody Person person) {
        personService.update(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);

    }

    @RequestMapping(value="/people/createRecords", method= RequestMethod.POST)
    public ResponseEntity<?> createAllRecords(@RequestBody Iterable<Person> people){
        personService.createAll(people);

        return new ResponseEntity<>(people, HttpStatus.CREATED);
    }
}
