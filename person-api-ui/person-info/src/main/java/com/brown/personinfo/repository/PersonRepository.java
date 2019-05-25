package com.brown.personinfo.repository;

import com.brown.personinfo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:4200")
public interface PersonRepository extends JpaRepository<Person, Long> {
}
