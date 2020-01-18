package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.lti.model.Student;

public class StudentDaoImpl implements StudentDao {
private EntityManager entityManager;
	public StudentDaoImpl() {
	// TODO Auto-generated constructor stub

}

	@Override
	public int createStudent(Student student) {
     entityManager.getTransaction().begin();
     entityManager.persist(student);
     entityManager.getTransaction().commit();
     return 1;
		
	}

	@Override
	public Student readStudentByRollNumber(int rollNumber) {
    return entityManager.find(Student.class,rollNumber);
		
	}

	@Override
	public int updateStudentByRollNumber(Student student) {
	return 0;
	}

	@Override
	public int deleteStudentByRollNumber(Student student) {
	
		return 0;
	}

	@Override
	public List<Student> readAllStudents() {
		 String jpql="From Student"	;
					TypedQuery<Student> tquery=entityManager.createQuery(jpql, Student.class);
		 
		return tquery.getResultList();
	}

}
