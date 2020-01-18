package com.lti.service;

import com.lti.model.Student;

public interface StudentService {
	public boolean addStudent(Student student);
	public Student findStudentByRollNumber(int rollNumber);
	public int modifyStudentByRollNumber(Student student);
	public int removeStudentByRollNumber(Student student);
	
}
