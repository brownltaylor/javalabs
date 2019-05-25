package com.brown.personinfo.service;

import com.brown.personinfo.domain.Person;
import com.brown.personinfo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void create(Person person){
        personRepository.save(person);
    }

    public Optional<Person> getOne(Long id){
        return personRepository.findById(id);
    }

    public Iterable<Person> getAll(){
        return personRepository.findAll();
    }

    public void update(Person person){
        personRepository.save(person);

    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public void createAll(Iterable<Person> people){
        personRepository.saveAll(people);
    }
}
