package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }



    @Override
    public List<Student> displayAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);

    }
}
