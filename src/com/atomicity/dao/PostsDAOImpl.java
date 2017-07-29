package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.atomicity.domain.Posts;

@Transactional
public class PostsDAOImpl implements PostsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Override
	@Transactional
	public List<Posts> getAllPosts() {
		Session sess = sessionFactory.getCurrentSession();
		Query query = sess.getNamedQuery("getAllPosts");
		List<Posts> posts = query.list();
		return posts;
	}

	@Override
	@Transactional
	public void push(Posts post) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(post);

	}

}
