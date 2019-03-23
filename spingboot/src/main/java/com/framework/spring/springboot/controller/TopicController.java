package com.framework.spring.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.spring.springboot.model.Topic;
import com.framework.spring.springboot.service.TopicService;

@RestController
public class TopicController {
	
	//register available service
	@Autowired
	private TopicService service;
	
	@RequestMapping("/topics")
	public List<Topic> all(){
		return service.getAllTopics();
	}

	@RequestMapping("/topics/name/{name}")
	public List<Topic> topicsByName(@PathVariable("name") String name){
		return service.getTopicsByName(name);
	}
	
	@RequestMapping("/topics/{foo}")
	public Topic getTopic(@PathVariable("foo") int id){
		return service.getTopic(id);
	}
	
	/**
	 * Important!!! 
	 * must add @Requestbody to json object, otherwise, parameter will be null
	 * @param topic
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic){
		service.add(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id){
		service.modify(topic, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{bar}")
	public void deleteTopic(@PathVariable("bar")int id){
		service.delete(id);
	}
}
