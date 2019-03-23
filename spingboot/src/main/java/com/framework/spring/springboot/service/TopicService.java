package com.framework.spring.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.spring.springboot.data.TopicRepository;
import com.framework.spring.springboot.model.Topic;

/**
 * Singleton instance, creates a singleton at application startup and cache it.
 * 
 */
@Service
public class TopicService {
	@Autowired
	private TopicRepository repository;
//	private static List<Topic> topics;
//	
//	static{
//		topics = new ArrayList<>(Arrays.asList(new Topic(101, "Business", "Financial news"), new Topic(102, "Reading", 
//				"Newest books, the most popular books")));
//	}
	
	public List<Topic> getAllTopics(){
//		return topics;
		List<Topic> topics = new ArrayList<Topic>();
		repository.findAll().forEach(topics::add);
		return topics;
	}
	
	public List<Topic> getTopicsByName(String name){
		return repository.findByName(name);
	}
	
	
	public Topic getTopic(int id){
		//filter out
//		return topics.stream().filter(t -> t.getId()==id).findFirst().get();
//		for(Topic t: topics){
//			if(t.getId() == id)
//				return t;
//		}
//		return null;
		return repository.findOne(id);
	}
	
	public void modify(Topic topic, int id){
//		delete(topic.getId());
//		add(topic);
		repository.save(topic);
	}

	public void add(Topic topic){
//		topics.add(topic);
		repository.save(topic);
	}

	public void delete(int id){
//		topics.remove(getTopic(id));
		repository.delete(id);
	}
	
}
