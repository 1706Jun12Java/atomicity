package com.atomicity.dao;

import java.util.List;

import com.atomicity.domain.Mail;

public interface MailDAO {

	public List<Mail> getMailByUsername(String username);

	public void push(Mail mail);
}
