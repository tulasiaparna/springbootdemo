
package com.example.demo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;

@Entity
@Table
public class employee {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String dept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public String getDept() {
		return dept;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public employee() {
		
	}
}

