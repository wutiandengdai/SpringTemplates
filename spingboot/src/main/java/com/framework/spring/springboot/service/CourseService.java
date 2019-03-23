package com.framework.spring.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.spring.springboot.data.CourseRepository;
import com.framework.spring.springboot.model.Course;

@Service
public class CourseService {
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAll(){
		List<Course> courses = new ArrayList<Course>();
		repository.findAll().forEach(courses::add);;
		return courses;
	}
	
	public List<Course> findAllCoursesByTopic(int topicId){
		List<Course> courses = new ArrayList<Course>();
		repository.findByTopicId(topicId).forEach(courses::add);;
		return courses;
	}
	
	public Course getCourseById(int id){
		return repository.findOne(id);
	}
	
	public void updateAndAddCourse(Course course){
		repository.save(course);
	}
	
	public void deleteCourse(int id){
		repository.delete(id);
	}
}
