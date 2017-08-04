package com.atomicity.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.atomicity.domain.Mail;
import com.atomicity.util.HibernateUtil;

public class MailDAOImpl implements MailDAO {

	@Override
	public List<Mail> getMailByUsername(String username) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.getNamedQuery("getMailByUsername");
		query.setString("var", username);
		List<Mail> mail = query.list();
		sess.close();
		return mail;
	}

	@Override
	public void push(Mail mail) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = sess.beginTransaction();
		sess.save(mail);
		tx.commit();
		sess.close();
	}

}
