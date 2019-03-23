package com.framework.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.spring.springboot.model.Course;
import com.framework.spring.springboot.model.Topic;
import com.framework.spring.springboot.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getCoursesByTopic(@PathVariable int topicId){
		return service.findAllCoursesByTopic(topicId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void saveCourse(@RequestBody Course course, @PathVariable int topicId){
		//new Topic here create a link, but not insert a new record
		course.setTopic(new Topic(topicId, null, null));
		service.updateAndAddCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id){
		//new Topic here create a link, but not insert a new record
		course.setTopic(new Topic(topicId, "default", "default"));
		service.updateAndAddCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable int topicId, @PathVariable int id){
		service.deleteCourse(id);
	}
}
