package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository repo;
  
  public EmployeeService(EmployeeRepository repo) {
	  this.repo=repo;
  }
  
  public employee addemployee(employee emp) {

	   return repo.save(emp);
	   
}
 public List<employee> findall(){
	 return repo.findAll();
 }
 public Optional<employee> findbyid(int id) {
	 return repo.findById(id);
 }
 public void deletebyid(int id) {
	 repo.deleteById(id);
 }
 
 public employee save(employee emp) {
	 //emp.setId(id);
	return repo.save(emp);
 }
 
}