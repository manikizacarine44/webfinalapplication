package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String faculty;
   private String department;
   private String amount;
   private String password;
public Student() {
	super();
}
public Student(Long id, String name, String faculty, String department, String amount, String password) {
	super();
	this.id = id;
	this.name = name;
	this.faculty = faculty;
	this.department = department;
	this.amount = amount;
	this.password = password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFaculty() {
	return faculty;
}
public void setFaculty(String faculty) {
	this.faculty = faculty;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}   
   
   
}
