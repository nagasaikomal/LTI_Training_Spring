package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Student;
import com.lti.service.StudentService;

@Controller 
public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String homePage(){
		return "index";
	}
	
	@RequestMapping(path="addStudent.view" , method=RequestMethod.GET)
	public String addStudentView(){
		return "addStudent";
	}
	
	@RequestMapping(path="addStudent.do" , method=RequestMethod.POST)
	public String addStudent(Student student){
		// I don't require following steps
		// String rollNumber = request.getParameter("rollNumber");
		boolean result = service.addStudent(student);
		if(result){
			return "redirect:findAllStudents.do";
		}
		else{
			return "error";
		}
	}
	
	@RequestMapping(path="findAllStudents.do")
	public String findAllStudents(Model model){
		List<Student> students = service.findAllStudents();
		model.addAttribute("students", students);
		return "viewAllStudents";
	}
}
