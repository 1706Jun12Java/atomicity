package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.atomicity.domain.Post;
import com.atomicity.util.HibernateUtil;

public class PostDAOImpl implements PostDAO {

	@Override
	public List<Post> getAllPosts() {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllPosts");
		List<Post> posts = query.list();
		sess.close();
		return posts;
	}

	@Override
	public List<Post> getAllByTopicId(int id) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getAllByTopicId");
		query.setInteger("var", id);
		List<Post> posts = query.list();
		sess.close();
		return posts;
	}

	@Override
	public void push(Post post) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(post);
		tx.commit();
		sess.close();

	}

}