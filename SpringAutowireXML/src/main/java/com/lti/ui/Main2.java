package com.lti.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.model.Student;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        
		Student student=(Student)context.getBean("student3");
		
		System.out.println(student);
		System.out.println(student.getAddress());
		
	}

}
