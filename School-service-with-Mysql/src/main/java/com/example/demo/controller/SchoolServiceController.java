package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.delegate.StudentServiceDelegate;

@RestController
public class SchoolServiceController {
	
	@Autowired
	StudentServiceDelegate studentServiceDelegate;

	@RequestMapping(value = "/getDetails/", method = RequestMethod.GET)
	public String getStudents() {
		System.out.println("Going to call student service to get data!");
		return studentServiceDelegate.callStudentServiceAndGetData();
	}

	@RequestMapping(value = "/createStudent/", method = RequestMethod.GET)
	public String createStudent() {
		System.out.println("Going to call student service to get data!");
		return studentServiceDelegate.callStudentServiceForCreate();
	}
	
}