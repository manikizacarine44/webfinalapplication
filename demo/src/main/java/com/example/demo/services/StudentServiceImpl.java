package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.reprositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices{
	
	@Autowired
	public StudentRepository studRepo;
	

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studRepo.findAll();
	}

	@Override
	public void saveStudents(Student students) {
		// TODO Auto-generated method stub
		this.studRepo.save(students);
	}

	@Override
	public Student findById(Long id) {
		Optional<Student> optional=studRepo.findById(id);
		Student student=null;
		if(optional.isPresent())
		{
			student=optional.get();
			
			
		}else {
			throw new RuntimeErrorException(null,"student not found"+id);
			
		}
		return student;
		
	}

	@Override
	public void deleteStudents(Long id) {
		this.studRepo.deleteById(id);
		
	}

	@Override
	public boolean authenticateUser(Long id, String password) {
		Student st=studRepo.getById(id);
		return st !=null && st.getPassword().equals(password);
	}
	

}
