package com.atomicity.daoTest;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.*;

import com.atomicity.dao.*;
import com.atomicity.domain.*;

public class UserDAOTest {

	@Test
	public void testGetUsers() {
		UserDAO udao = new UserDAOImpl();
		List<User> list = udao.getAllUser();
		assertNotNull(list);
	}

	@Test
	public void testGetPosts() {
		PostDAO pdao = new PostDAOImpl();
		List<Post> list = pdao.getAllPosts();
		assertNotNull(list);
	}
	
	@Test
	public void testGetTopics() {
		TopicDAO tdao = new TopicDAOImpl();
		List<Topic> list = tdao.getAllTopics();
		assertNotNull(list);
	}
	
	@Test
	public void testGetMail() {
		MailDAO tdao = new MailDAOImpl();
		List<Mail> list = tdao.getMailByUsername("t");
		assertNotNull(list);
	}
}
