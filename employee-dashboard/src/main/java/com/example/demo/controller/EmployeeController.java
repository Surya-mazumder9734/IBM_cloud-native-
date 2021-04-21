package com.example.demo.controller;

import com.example.demo.employeeDto.EmployeeDto;
import com.example.demo.feignClient.EmployeeFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeFeign employeeFeign;

    @GetMapping(path = "employees", produces = "application/json")
     public ResponseEntity<List<EmployeeDto>> getEmployees()
    {
        return employeeFeign.getAllEmployeeFromClient();
    }
    @PostMapping("/employee")
    public ResponseEntity<?> createEmployeeFromClient(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeFeign.createEmployeeFromClient(employeeDto));

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeFeign.getEmployeeById(id));
    }
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteProduct(@PathVariable Integer id){
        this.employeeFeign.deleteProduct(id);
        return HttpStatus.OK;
    }


}
