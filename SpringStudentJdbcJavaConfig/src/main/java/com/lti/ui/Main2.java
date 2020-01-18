package com.lti.ui;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.config.AppConfig;
import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main2 {
	private static ApplicationContext context;
	
	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		Scanner scanner = new Scanner(System.in);
		StudentService service = context.getBean("service",StudentService.class);
		boolean flag= true;
		do{
			System.out.println("1. Add Student");
			System.out.println("2. Find Student");
			System.out.println("3. Modify Student");
			System.out.println("4. Delete Student");
			System.out.println("0. Exit Application");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Student Roll Number: ");
				int rollNumber = scanner.nextInt();
				System.out.println("Enter Student Name: ");
				String studentName = scanner.next();
				System.out.println("Enter Student Score: ");
				double score = scanner.nextDouble();
				Student student = context.getBean("student",Student.class);
				student.setRollNumber(rollNumber);
				student.setStudentName(studentName);
				student.setStudentScore(score);
				boolean result = service.addStudent(student);
				if(result){
					System.out.println("Student with roll number "+student.getRollNumber()+ " added successfully in database");
				}
				else{
					System.out.println("There is some technical problem. Please try again!");
				}
				break;
			case 2:
				System.out.println("Enter Rollnumber of the student to be searched: ");
				rollNumber = scanner.nextInt();
				Student student2 = service.findStudentByRollNumber(rollNumber);
				System.out.println(student2);
				break;
			case 3:
				System.out.println("Enter Rollnumber of the student to be searched: ");
				rollNumber = scanner.nextInt();
				System.out.println("Enter studentName of the student to be updated: ");
				studentName = scanner.next();
				Student student1 = context.getBean("student",Student.class);
				student1.setStudentName(studentName);
				student1.setRollNumber(rollNumber);
				int student3 = service.modifyStudentByRollNumber(student1);
				System.out.println(student3+" record updated");
				break;
			case 4:
				System.out.println("Enter Rollnumber of the student to be searched: ");
				rollNumber = scanner.nextInt();
				Student student5 = context.getBean("student",Student.class);
				student5.setRollNumber(rollNumber);
				int student4 = service.removeStudentByRollNumber(student5);
				System.out.println(student4+" record deleted");
				break;
			case 0:
				flag = false;
			}
		}while(flag);

		
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	public static void setContext(ApplicationContext context) {
		Main2.context = context;
	}

}
