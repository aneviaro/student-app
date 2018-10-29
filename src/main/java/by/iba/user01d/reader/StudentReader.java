package by.iba.user01d.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.iba.user01d.common.*;
public class StudentReader {
	private final String path;
	public StudentReader(String path){
		this.path=path;
	}
	public List<Student> read() throws IOException{
		List<Student> students = new ArrayList<>();
		try(BufferedReader br=new BufferedReader(new FileReader(path))){
			String line = null;
			while((line=br.readLine())!=null){
				String[] data = line.split(";");
				Student student=new Student();
				student.setId(data[0]);
				student.setFirstName(data[1]);
				student.setSecondName(data[2]);
				student.setGroupNumber(Integer.valueOf(data[3]));
				student.setAvgMark(Integer.valueOf(data[4]));
				students.add(student);
				
			}
		}
		return students;		
	}
}
