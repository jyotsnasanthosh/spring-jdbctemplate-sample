package com.spring.jdbc.model;

public class Student {

	private String name;
	private String id;
	private int age;
	private String department;

	public Student() {

	}

	public Student(String name, String id, int age, String department) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + ", department="
				+ department + "]";
	}
}
