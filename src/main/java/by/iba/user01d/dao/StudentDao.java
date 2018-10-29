package by.iba.user01d.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import by.iba.user01d.common.Student;

public class StudentDao {
	private final Map<String,Student> students=new LinkedHashMap<>();
	public StudentDao(List<Student> students){
		if(students!=null){
			for(Student student : students){
				this.students.put(student.getId(), student);
			}
		}
	}
	public List<Student> findAll(){
		return new ArrayList<Student>(students.values());
	}
	public Student create(Student student){
		String id = UUID.randomUUID().toString();
		student.setId(id);
		students.put(id, student);
		return student;
	}
	public void remove(String id){
		students.remove(id);
	}
}
