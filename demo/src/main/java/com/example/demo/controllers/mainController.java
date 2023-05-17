package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.demo.models.Student;
import com.example.demo.services.StudentServices;

import jakarta.servlet.http.HttpSession;

import com.example.demo.models.*;


@Controller
public class mainController {
	@Autowired
	public StudentServices studentServ;
	
	@GetMapping("/adminPort")
	   public String showAdminPortal(Model model) {
		
		return "admin";
		
		}
	
	@GetMapping("/")
   public String showStudReg(Model model) {
		Student st=new Student();
		model.addAttribute("student", st);
	return "index";
	
	}	
	@PostMapping("/saveStud")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentServ.saveStudents(student);
		return "redirect:/studLogin";
	
	}
	@GetMapping("/studLogin")
	public String StudentLogin(Model model) {
		model.addAttribute("student", new Student());
		return "login";
	
	}
	@PostMapping("/authenticateUser")
    public String login(@ModelAttribute("student") Student student, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }

        if (studentServ.authenticateUser(student.getId(),student.getPassword())) {
            session.setAttribute("id", student.getId());
            return "redirect:/listStudents";
        } else {
        	
            result.rejectValue("password", "error.student", "Invalid username or password");
            return "login";
        }
}
	@GetMapping("/listStudents")
	   public String showStudList(Model model) {
		model.addAttribute("student",studentServ.getAllStudents());
		return "studList";
		
		}	
	@GetMapping("/deleteStud/{id}")
	   public String deleteStud(@PathVariable(value = "id")Long id ) {
		this.studentServ.deleteStudents(id);
		
		return "redirect:/listStudents";
		
		}	
	@GetMapping("/updateStud/{id}")
	   public String showStudUpdatePage(@PathVariable(value = "id")Long id ,Model model) {
		Student st=studentServ.findById(id);
		model.addAttribute("student", st);
		
		return "studUpdate";
		
		}	
}
