package com.example.demo.services;
import java.util.List;

import com.example.demo.models.*;
public interface StudentServices  {
	List<Student> getAllStudents();
	void saveStudents(Student students);
	Student findById(Long id);
	void  deleteStudents(Long id);
	boolean authenticateUser(Long id, String password);
	

}
