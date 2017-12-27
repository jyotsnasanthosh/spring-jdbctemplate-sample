package com.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.model.Student;
import com.spring.jdbc.model.StudentMapper;

public class StudentDaoImpl implements StudentDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> findAll() {
		String getAllStudentsQuery = "select * from student";
		jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String, Object>> studentMaps = jdbcTemplate
				.queryForList(getAllStudentsQuery);

		if (null == studentMaps || studentMaps.size() <= 0) {
			return null;
		}

		List<Student> studentList = new ArrayList<Student>(studentMaps.size());

		for (Map map : studentMaps) {

			Student student = new Student();
			student.setAge(Integer.parseInt(String.valueOf(map.get("age"))));
			student.setName(String.valueOf(map.get("name")));
			student.setId(String.valueOf(map.get("id")));
			student.setDepartment(String.valueOf(map.get("department")));

			studentList.add(student);
		}
		return studentList;
	}

	public void create(Student student) {
		String addStudentQuery = "insert into student(id, name, age, department) values(?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(addStudentQuery,
				new Object[] { student.getId(), student.getName(), student.getAge(),
						student.getDepartment() });
	}

	public void update(Student student) {
		String updateStudentQuery = "update student set department=?, age=? where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(updateStudentQuery, new Object[] { student.getDepartment(),
				student.getAge(), student.getId() });

	}

	public void remove(String id) {
		String deleteStudentQuery = "delete from student where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(deleteStudentQuery, new Object[] { id });
	}

	public Student findById(String id) {
		String searchStudentQuery = "select id,name,age,department from student where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Student> studentList = jdbcTemplate.query(searchStudentQuery,
				new Object[] { id }, new StudentMapper());
		if (null == studentList || studentList.size() <= 0) {
			return null;
		}
		
		return studentList.get(0);

	}
}
