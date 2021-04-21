package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public  Employee createEmployee(Employee employee);
    Employee getProductById(Integer employeeId);

    //delete a product
    void deleteProduct(Integer id);
}
