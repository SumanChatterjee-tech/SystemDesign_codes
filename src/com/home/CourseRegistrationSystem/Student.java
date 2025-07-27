package com.home.CourseRegistrationSystem;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Student {
	private String id;
	private String name;
	private String email;
	private Set<Course> enrolledCourses;
	
	public Student(String name, String email) {
		super();
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.enrolledCourses = new HashSet<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Course> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(Course course) {
		this.enrolledCourses.add(course);
	}
	public void drop(Course course) {
		this.enrolledCourses.remove(course);
	}
}
