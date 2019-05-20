package com.brown.studentapi.services;

import com.brown.studentapi.model.Student;
import com.brown.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //this is a singleton-- an instance that can be shared across all the classes

    //CRUD Methods

    public void createStudent(Student student){
        studentRepository.save(student);

    }


    public Iterable<Student> list(){

        return studentRepository.findAll();
    }

    public void deleteStudent(Long id){

        studentRepository.deleteById(id);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }


    public Optional<Student> getStudent(Long id){
       return studentRepository.findById(id);
    }

}


