package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.atomicity.domain.Topic;
import com.atomicity.util.HibernateUtil;

public class TopicDAOImpl implements TopicDAO {

	@Override
	public List<Topic> getAllTopics() {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllTopics");
		List<Topic> topic = query.list();
		sess.close();
		return topic;
	}

	@Override
	public void push(Topic topic) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(topic);
		tx.commit();
		sess.close();

	}

	@Override
	public Topic getTopicsById(int id) {
		Session sess = HibernateUtil.getSession();
		return (Topic) sess.get(Topic.class, id);
	}

	@Override
	public List<Topic> getTopicsByCategory(String category) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllTopicsByCategory");
		query.setParameter("var", category);
		List<Topic> topics = query.list();
		return topics;
	}
}
