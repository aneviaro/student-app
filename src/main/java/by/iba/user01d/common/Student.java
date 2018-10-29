package by.iba.user01d.common;

import java.util.Random;

public class Student {
	private String firstName;
	private String secondName;
	private int groupNumber;
	private int avgMark;
	private String id;
	
	
	public Student(String firstName, String secondName, int groupNumber, String id) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.groupNumber = groupNumber;
		Random rn = new Random();
		this.avgMark=rn.nextInt(11);
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(int avgMark) {
		this.avgMark = avgMark;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", secondName=" + secondName + ", groupNumber=" + groupNumber
				+ ", avgMark=" + avgMark + "]";
	}
	
	
}
