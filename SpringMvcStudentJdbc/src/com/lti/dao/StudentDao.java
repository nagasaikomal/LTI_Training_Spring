package com.lti.dao;

import java.util.List;

import com.lti.model.Student;

public interface StudentDao {
	public int createStudent(Student student);
	public Student readStudentByRollNumber(int rollNumber);
	public int updateStudentByRollNumber(Student student);
	public int deleteStudentByRollNumber(Student student);
	public List<Student> readAllStudents();
}
