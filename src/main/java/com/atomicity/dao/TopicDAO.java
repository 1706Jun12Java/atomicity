package com.atomicity.dao;

import java.util.List;

import com.atomicity.domain.Topic;

public interface TopicDAO {

	public List<Topic> getAllTopics();

	public void push(Topic topics);
}