package com.atomicity.dao;

import java.util.List;

import com.atomicity.domain.Topic;

public interface TopicDAO {

	public List<Topic> getAllTopics();

	public List<Topic> getTopicsByCategory(String category);
	
	public void push(Topic topics);

	Topic getTopicsById(int id);

	
}