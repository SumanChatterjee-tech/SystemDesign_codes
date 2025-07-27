package com.home.CourseRegistrationSystem;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CourseRegistrationSystem {

	Map<String, Course> course;
	Map<String, Student> student;
	List<Registration> registrations;
	
	public CourseRegistrationSystem() {
		this.course = new ConcurrentHashMap<>();
		this.student = new ConcurrentHashMap<>();
		this.registrations = new ArrayList<>();
	}
	
	public Student registerStudent(String name, String email) {
		Student st = new Student(name, email);
		this.student.put(st.getId(), st);
		return st;
	}
	
	public Course addCourse(String code, String name, int capacity) {
		Course course = new Course(code, name, capacity);
		this.course.put(course.getCode(), course);
		return course;
	}
	
	public synchronized void enroll(String studentId, String courseCode) {
		Student student = this.student.get(studentId);
		Course course = this.course.get(courseCode);
		if(student == null || course == null) {
			throw new IllegalStateException();
		}
		maintainRegistrations(student, course, "ENROLL");
		student.setEnrolledCourses(course);
		course.setEnrolledStudents(student);
	}
	
	public synchronized void drop(String studentId, String courseCode) {
		Student student = this.student.get(studentId);
		Course course = this.course.get(courseCode);
		if(student == null || course == null) {
			throw new IllegalStateException();
		}
		maintainRegistrations(student, course, "DROP");
		student.drop(course);
		course.drop(student);
	}
	
	public void maintainRegistrations(Student student, Course course, String type) {
		if(type.equalsIgnoreCase("ENROLL")) {
			Registration rgs = new Registration(student, course, Timestamp.valueOf( LocalDateTime.now()));
			this.registrations.add(rgs);
		}else {
			//we need to keep registration as a MAP
		}
	}
	public List<Course> getAvailableCourses() {
        return course.values().stream().filter(Course::isCourseAvailable).collect(Collectors.toList());
    }

    public List<Course> searchCourses(String query) {
        List<Course> result = new ArrayList<>();
        for (Course course : course.values()) {
            if (course.getCode().contains(query) || course.getName().contains(query)) {
                result.add(course);
            }
        }
        return result;
    }
}
