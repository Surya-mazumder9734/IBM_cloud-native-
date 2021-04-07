package com.example.demo.service;

import com.example.demo.domain.Student;

import java.util.List;

public interface StudentService {

    public List<Student> displayAllStudent();
    public Student createStudent(Student student);
}
