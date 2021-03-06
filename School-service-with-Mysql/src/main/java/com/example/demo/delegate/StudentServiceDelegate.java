package com.example.demo.delegate;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class StudentServiceDelegate {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String callStudentServiceAndGetData() {
		System.out.println("Getting School details " );
		String response = restTemplate
				.exchange("http://localhost:8098/getStudentDetails/"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - :::  Student Details " + response + " -  " + new Date();
	}
	@HystrixCommand(fallbackMethod = "callStudentServiceAndGetData_Fallback")
	public String callStudentServiceForCreate() {
		System.out.println("Getting School details " );
		String response = restTemplate
				.exchange("http://localhost:8098/createStudent/"
						, HttpMethod.POST
						, null
						, new ParameterizedTypeReference<String>() {
						}).getBody();

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - :::  Student Details " + response + " -  " + new Date();
	}


	@SuppressWarnings("unused")
	private String callStudentServiceAndGetData_Fallback() {
		System.out.println("Student Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Student Service at this moment. Service will be back shortly - " + new Date();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
