package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.StudentDao;
import com.lti.model.Student;

@Service("service")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;
	
	@Override
	public boolean addStudent(Student student) {
		int result = dao.createStudent(student);
		if(result==1)
			return true;
		else
			return false;
	}

	@Override
	public Student findStudentByRollNumber(int rollNumber) {
		Student result=dao.readStudentByRollNumber(rollNumber);
		return result;
	}

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	public int modifyStudentByRollNumber(Student student) {
		int result=dao.updateStudentByRollNumber(student);
		return result;
	}

	@Override
	public int removeStudentByRollNumber(Student student) {
		int result=dao.deleteStudentByRollNumber(student);
		return result;
	}

}
