package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public StudentDaoImpl() {
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int createStudent(Student student) {
		entityManager.persist(student);
		return 1;
	}

	@Override
	@Transactional
	public Student readStudentByRollNumber(int rollNumber) {

		return entityManager.find(Student.class, rollNumber);
	}

	@Override
	@Transactional
	public int updateStudent(Student student) {

		return 0;
	}

	@Override
	@Transactional
	public int DeleteStudentByRollNumber(int rollNumber) {
			String jpql = "DELETE FROM Student where rollNumber = :rollNo";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("rollNo", rollNumber);
			int result = query.executeUpdate();
		return result;
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {
		String jpql = "From Student";
		TypedQuery<Student> typed = entityManager.createQuery(jpql, Student.class);

		return typed.getResultList();
	}

}
