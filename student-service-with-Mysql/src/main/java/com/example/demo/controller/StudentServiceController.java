package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentServiceController {

    private StudentService studentService;

    public StudentServiceController(StudentService studentService) {
        this.studentService = studentService;
    }



    @RequestMapping(value = "/getStudentDetails", method = RequestMethod.GET)
    public List<Student> getStudents() {


        return studentService.displayAllStudent();
    }

    @RequestMapping(value = "/createStudent",method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }
}
