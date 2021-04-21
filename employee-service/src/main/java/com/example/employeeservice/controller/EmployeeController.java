package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
@Autowired
    private EmployeeService employeeService;


    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllTodos()
    {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeService.getProductById(id));
    }
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteProduct(@PathVariable Integer id){
        this.employeeService.deleteProduct(id);
        return HttpStatus.OK;
    }

}
