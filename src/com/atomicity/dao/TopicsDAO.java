package com.atomicity.dao;

import java.util.List;

import com.atomicity.domain.Topics;

public interface TopicsDAO {

	public List<Topics> getAllTopics();

	public void push(Topics topics);
}
