package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username) {
		return todoService.findByUsername(username);
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@GetMapping("/users/{username}/todos/{id}")
	public Todo findTodoById(@PathVariable String username, @PathVariable Integer id) {
		return todoService.findById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id) {
		todoService.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
		return ResponseEntity.noContent().build(); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	@PostMapping("/users/{username}/todos/")
	public Todo createTodo(@RequestBody Todo todo) {
		System.out.println("Recieved new TODO: " + todo.toString());
		Todo newTodo = todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return newTodo; 
	}
}
