package com.example.employeeservice.service;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements  EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getProductById(Integer employeeId) {
        return employeeRepo.findByEmployeeId(employeeId);
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<Employee> productDb=this.employeeRepo.findById(id);
        if(productDb.isPresent()) {
            this.employeeRepo.delete(productDb.get());
        }
    }
}
