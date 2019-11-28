package com.cs.ement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.ement.domain.Student;
import com.cs.ement.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentRepo.findAll();
		if(students.isEmpty()) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(students);
		return ResponseEntity.status(HttpStatus.OK).body(students); 
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
}
