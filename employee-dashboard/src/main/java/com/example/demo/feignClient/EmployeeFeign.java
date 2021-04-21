package com.example.demo.feignClient;

import com.example.demo.employeeDto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeFeign {
    
    @PostMapping("/employee")
    public ResponseEntity<?> createEmployeeFromClient(@RequestBody EmployeeDto employeeDto);

    @GetMapping("/employee")
    public  ResponseEntity<List<EmployeeDto>> getAllEmployeeFromClient();

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") Integer id);

    @DeleteMapping(path = "/employees/{id}")
    public HttpStatus deleteProduct(@PathVariable("employeeId") Integer id);




}
