package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "class_Name")
    private String className;

    public Student() {
        super();
    }

    public Student(Integer id, String name, String className) {
        this.id = id;
        this.name = name;
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}