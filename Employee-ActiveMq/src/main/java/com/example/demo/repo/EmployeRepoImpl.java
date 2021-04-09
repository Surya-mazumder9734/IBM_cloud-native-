package com.example.demo.repo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;

@Component
public class EmployeRepoImpl implements EmployeeRepo {
	private Map<Integer, Employee> employeeMap;
	{
		employeeMap=new HashMap<Integer, Employee>();
		employeeMap.put(1, new Employee(1,"Rahul","darvid","d@3mail"));
		employeeMap.put(2, new Employee(2, "Marry", "Public", "marry@email.com"));
		employeeMap.put(3, new Employee(3, "Virat", "kohali", "virat@email.com"));
		employeeMap.put(4, new Employee(4, "Sourav", "Ganguly", "sourav@email.com"));
	}
	@Override
	public Collection<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeMap.values();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Employee employee=employeeMap.get(id);
		
		return employee;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMap.put(employeeMap.size()+1, employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Integer id,Employee employee) {
		Employee tempEmployee=employeeMap.get(id);
		
		tempEmployee.setFirstName(employee.getFirstName());
		tempEmployee.setLastName(employee.getLastName());
		tempEmployee.setEmail(employee.getEmail());
		employeeMap.remove(id);
		employeeMap.put(id, tempEmployee);
		return tempEmployee;
	}

}