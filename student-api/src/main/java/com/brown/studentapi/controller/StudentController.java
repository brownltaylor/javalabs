package com.brown.studentapi.controller;

import com.brown.studentapi.model.Student;
import com.brown.studentapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/student", method = RequestMethod.POST) //localhost:8080/student will take you to the page to create a student record
    public void createStudentRecord(@RequestBody Student student){
        studentService.createStudent(student);

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Iterable<Student> getStudentRecords(){
        return studentService.list();
    }

    @RequestMapping(value = "/list/{id}", method = RequestMethod.DELETE)
    public void deleteStudentRecordById(@PathVariable Long id){
        studentService.deleteStudent(id);
    }


    @RequestMapping(value = "/list/{id}", method= RequestMethod.PUT)
    public void updateStudentRecord(@RequestBody Student student, @PathVariable Long id){
        studentService.updateStudent(student);

    }


    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Optional<Student> getStudentRecord(@PathVariable Long id){
        return studentService.getStudent(id);
    }
}
