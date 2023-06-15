package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@SpringBootApplication
@RestController
@RequestMapping("/home")
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
    @Autowired
	EmployeeRepository repo;
	//@Autowired
	//public Demo1Application(EmployeeRepository employeeRepository) {
		//this.employeeRepository = employeeRepository;
	//}
//	@GetMapping(value = "/api/vi/{message}")
//	@ResponseBody
//	public String display(
//			@PathVariable("message") String message) {
//		return "hello world "+message;
//	}
    
    @GetMapping("/h")
    public ModelAndView roll() {
    	System.out.println("model");
    	return new ModelAndView("ab");
    }
	@GetMapping("/")
	public String display() {
		System.out.println("JSP");
		return "ab";
	}
	@GetMapping("/display")
	public List<employee> getEmployees(){
		return repo.findAll();
	}
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody employee emp) {
		 repo.save(emp);
		 return "Success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletecustomers(@PathVariable("id") int id) {
		repo.deleteById(id);
		return "Deleted "+id+" succesfully";
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") int id,@RequestBody employee emp,@RequestParam(required=false) String email,@RequestParam(required=false) String name) {
		//emp.setName(name);
		//emp.setEmail(email);
		emp.setId(id);
		repo.save(emp);
		return "updated "+id+" sucessfully";
	}
	
}
