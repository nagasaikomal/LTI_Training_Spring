package com.lti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lti.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		int rollNumber = rs.getInt("ROLL_NUMBER");
		String studentName = rs.getString("STUDENT_NAME");
		double score = rs.getDouble("STUDENT_SCORE");
		
		Student student = new Student();
		student.setRollNumber(rollNumber);
		student.setStudentName(studentName);
		student.setStudentScore(score);
		return student;
	}
	
}
