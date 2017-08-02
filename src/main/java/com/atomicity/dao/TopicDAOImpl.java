package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import com.atomicity.domain.Topic;
import com.atomicity.util.HibernateUtil;

@Transactional
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
	@Transactional
	public void push(Topic topic) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(topic);
		tx.commit();
		sess.close();

	}

}
