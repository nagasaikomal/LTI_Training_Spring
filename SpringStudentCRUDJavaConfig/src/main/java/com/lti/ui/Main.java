package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Student;
import com.lti.service.StudentService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext=new AnnotationConfigApplicationContext(AppConfig.class);
		Student student=appContext.getBean("student",Student.class);
		//System.out.println(student);
		//System.out.println(student.getAddress());
		
		student.setRollNumber(46);
		student.setStudentName("komal");
		student.setStudentScore(67.5);
		student.getAddress().setAddressId(10);
		student.getAddress().setCity("kakinada");
		student.getAddress().setPin("533001");
		
		StudentService service=appContext.getBean("service",StudentService.class);
		boolean result=service.addStudent(student);
		if(result){
			System.out.println("student is added");
			Student student2=service.findStudentByRollNumber(46);
			System.out.println(student2);
			System.out.println(student2.getAddress());
			
		}else{
			System.out.println("student is not added");
			
		}
		
			
		
		
		

	}

}
