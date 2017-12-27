package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.model.Student;

public interface StudentDao {

	public List<Student> findAll();

	public void create(Student student);

	public void update(Student student);

	public void remove(String id);

	public Student findById(String id);
}
