package com.example.demo.controller;

import java.util.Collection;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class Employeecontroller {
	private Queue queue;
	private JmsTemplate jmsTemplate;
	private EmployeeService service;

	@Autowired
	public  Employeecontroller(Queue queue, JmsTemplate jmsTemplate,EmployeeService service) {
		super();
		this.queue = queue;
		this.jmsTemplate = jmsTemplate;
		this.service=service;
	}
	@GetMapping(path = "/employees", produces = "application/json")
	public ResponseEntity<Collection<Employee>> findAllEmployee() {

		return ResponseEntity.status(HttpStatus.OK).body(service.getAllEmployee());
	}
	
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		jmsTemplate.convertAndSend(queue,"I am ok");

		return ResponseEntity.status(HttpStatus.OK).body(service.getEmployeeById(id));
	}
	@PostMapping(path = "/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		jmsTemplate.convertAndSend(queue,"Employee created");

		return ResponseEntity.status(HttpStatus.CREATED).body(service.createEmployee(employee));
	}
	
	@PutMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
	{		jmsTemplate.convertAndSend(queue,"Employee updated");

		Employee e=service.updateEmployee(id, employee);
		return ResponseEntity.status(HttpStatus.OK).body(e);
	}
}