package com.example.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.TodoDto;

@FeignClient(name = "todo-service")
public interface TodoFeignClient {
	
	@PostMapping("/todos")
	public ResponseEntity<TodoDto> createTodoFromClient(@RequestBody TodoDto todoDto);
	@GetMapping("/todos")
	public ResponseEntity<List<TodoDto>> displayTodosFromclient(); 
	@GetMapping("/status")
	public ResponseEntity<?> getStatusFromClient();
	

}