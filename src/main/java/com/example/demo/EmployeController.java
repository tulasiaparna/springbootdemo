package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	 EmployeeRepository repo;

	//@GetMapping("/h")
    //public ModelAndView roll() {
    	//System.out.println("model");
    	//return new ModelAndView("ab");
    //}
	@GetMapping("/")
	public String func() {
		return "Hello World";
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
