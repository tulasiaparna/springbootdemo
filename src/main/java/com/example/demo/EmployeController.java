package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class EmployeController {
	 
	 @Autowired
	 EmployeeService service;

	public EmployeController(EmployeeService service) {
		this.service=service;
	}
	@CrossOrigin
	@GetMapping("/")
	public String func() {
		return "Hello World";
	}
	@CrossOrigin
	@GetMapping("/display")
	public ResponseEntity<List<employee>> getEmployees(){
		return new ResponseEntity<>(service.findall(),HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/display/{id}")
	public ResponseEntity<employee> getEmployeeById(@PathVariable("id") int id){
		Optional<employee> emp=service.findbyid(id);
		if(emp!=null) return new ResponseEntity<>(HttpStatus.FOUND);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<employee> addEmployee(@RequestBody employee emp) {
		employee newemp=service.addemployee(emp);
		return new ResponseEntity<>(newemp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletecustomers(@PathVariable("id") int id) {
		service.deletebyid(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<employee> update(@PathVariable("id") int id,@RequestBody employee emp,@RequestParam(required=false) String email,@RequestParam(required=false) String name) {
		//emp.setId(id);
		service.save(emp);
		return new ResponseEntity<>(emp,HttpStatus.ACCEPTED);
	}
	
	
}
