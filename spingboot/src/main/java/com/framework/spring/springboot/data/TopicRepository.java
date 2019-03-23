package com.framework.spring.springboot.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.framework.spring.springboot.model.Topic;

/**
 * CrudRepository provides all the standard CRUD method
 * @author Administrator
 * CrudRepository<Entity, Primary key Type>
 */
public interface TopicRepository extends CrudRepository<Topic, Integer>{

	/**
	 * No need to implement this self-defined method when it forms exactly int ther pattern of "findByProperty"
	 * @param name
	 * @return
	 */
	public List<Topic> findByName(String name);
	public List<Topic> findByDescription(String desc);
}
