package com.spring.jdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet resultset, int value) throws SQLException {

		Student student = new Student();
		student.setId(resultset.getString("id"));
		student.setName(resultset.getString("name"));
		student.setAge(resultset.getInt("age"));
		student.setDepartment(resultset.getString("department"));

		return student;
	}
}
