package com.framework.spring.springboot.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.framework.spring.springboot.model.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>{
	/**
	 * Naming Format: findBy+relation table + relationTableProperty
	 * @param topicId
	 * @return
	 */
	public List<Course> findByTopicId(int topicId);
}
