package com.home.CourseRegistrationSystem;

import java.util.HashSet;
import java.util.Set;

public class Course {

	private String code;
	private String name;
	private int maxCapacity;
	private Set<Student> enrolledStudents;
	public Course(String code, String name, int maxCapacity) {
		super();
		this.code = code;
		this.name = name;
		this.maxCapacity = maxCapacity;
		this.enrolledStudents = new HashSet<>();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(Student student) {
		if(this.maxCapacity <= enrolledStudents.size()) {
			throw new IllegalStateException("Max enrollment capacity reached");
		}
		this.enrolledStudents.add(student);
	}
	
	public void drop(Student student) {
		this.enrolledStudents.remove(student);
	}
	
	public boolean isCourseAvailable() {
		return this.maxCapacity > enrolledStudents.size();
	}
}
