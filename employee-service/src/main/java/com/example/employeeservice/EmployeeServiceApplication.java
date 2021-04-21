package com.example.employeeservice;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeServiceApplication implements CommandLineRunner {
    private EmployeeRepo employeeRepo;

    public EmployeeServiceApplication(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Autowired

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    employeeRepo.save(new Employee("1","Jatin","singh","jatin@main.com"));
        employeeRepo.save(new Employee("2","Suresh","Das","Suresh@main.com"));
        employeeRepo.save(new Employee("3","Mohan","Lal","mohan@main.com"));

    }
}
