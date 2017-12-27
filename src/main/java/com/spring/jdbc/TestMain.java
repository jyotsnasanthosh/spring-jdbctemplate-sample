package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.model.Student;

public class TestMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");

		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		List<Student> studentList = studentDao.findAll();
		Log("Updated student list", studentList.toString());

		// adding new student
		Student student = new Student("Sharika", "S02", 28, "CS");
		studentDao.create(student);
		studentList = studentDao.findAll();
		Log("Updated student list", studentList.toString());

		// searching a student by Id
		student = studentDao.findById("S02");
		student.setAge(27);

		// updating student details
		studentDao.update(student);
		Log("After updation", student.toString());

		// deleting student details
		studentDao.remove("S02");

		studentList = studentDao.findAll();
		Log("Final student list", studentList.toString());

		context.close();
	}

	static void Log(String tag, String message) {
		System.out.println(String.format("[Logger] %s --> %s", tag, message));
	}
}
