package com.lti.service;

import java.util.List;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student findStudentByRollNumber(int rollNumber);
	public int modifyStudentByRollNumber(Student student);
	public int removeStudentByRollNumber(Student student);
	public List<Student> findAllStudents();
	
}
