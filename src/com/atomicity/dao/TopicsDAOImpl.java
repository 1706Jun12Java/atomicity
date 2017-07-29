package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.atomicity.domain.Topics;

@Transactional
public class TopicsDAOImpl implements TopicsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Override
	@Transactional
	public List<Topics> getAllTopics() {
		Session sess = sessionFactory.getCurrentSession();
		Query query = sess.getNamedQuery("getAllTopics");
		List<Topics> topic = query.list();
		return topic;
	}

	@Override
	@Transactional
	public void push(Topics topic) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(topic);

	}

}
