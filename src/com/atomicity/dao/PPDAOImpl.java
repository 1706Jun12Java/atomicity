package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.atomicity.domain.ProfilePics;

@Transactional
public class PPDAOImpl implements PPDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
	}

	@Override
	@Transactional
	public void push(ProfilePics newPic) {
		Session sess = sessionFactory.getCurrentSession();
		sess.save(newPic);
	}

	@Override
	@Transactional
	public void update(ProfilePics Pic, byte[] newPic) {
		Session sess = sessionFactory.getCurrentSession();
		Pic.setPic(newPic);
		sess.update(Pic);
	}

	@Override
	@Transactional
	public ProfilePics getPicByName(String username) {
		Session sess = sessionFactory.getCurrentSession();
		Query query = sess.getNamedQuery("getAllPics");
		List<ProfilePics> pics = query.list();
		ProfilePics pic = pics.get(0);
		return pic;

	}

}
