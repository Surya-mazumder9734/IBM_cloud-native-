package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TodoDto;
import com.example.demo.feign.TodoFeignClient;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class ClientController {
	private TodoFeignClient todoFeignClient;

	private Environment enviroment;

	public ClientController(TodoFeignClient todoFeignClient, Environment enviroment) {
		super();
		this.todoFeignClient = todoFeignClient;
		this.enviroment = enviroment;
	}
	 @GetMapping("/status")
	    public ResponseEntity<String> getStatus()
	    {
	        return ResponseEntity.ok("service is up and listining on port"+enviroment.getProperty("local.server.port"));
	    }
	@PostMapping("/clients")
	public ResponseEntity<?> createTodo(@RequestBody TodoDto todoDto)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(todoFeignClient.createTodoFromClient(todoDto));
	}
	
	@GetMapping("/clients")
	public ResponseEntity<?> displayAllTodos()
	{
		return ResponseEntity.ok(todoFeignClient.displayTodosFromclient());
	}
}
