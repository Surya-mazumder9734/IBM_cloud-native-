package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class city {
@Id
private Integer id;
@Column(name = "name")
private String name;

}