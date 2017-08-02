package com.atomicity.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;
import com.atomicity.domain.ProfilePic;
import com.atomicity.util.HibernateUtil;

@Transactional
public class ProfilePicDAOImpl implements ProfilePicDAO {

	@Override
	public void push(ProfilePic newPic) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(newPic);
		tx.commit();
		sess.close();
	}

	@Override
	public void update(ProfilePic Pic, byte[] newPic) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		Pic.setPic(newPic);
		sess.update(Pic);
		tx.commit();
		sess.close();
	}

	@Override
	public ProfilePic getPicByName(String username) {
		Session sess = HibernateUtil.getSession();
		ProfilePic pic = (ProfilePic) sess.get(ProfilePic.class, username);
		return pic;

	}

}