package com.atomicity.domain;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
		@NamedQuery(name = "getMailByUsername", query = "FROM Mail WHERE reciever = :var ORDER BY dateSubmitted DESC") })

@Entity
@Table(name = "A_MAIL")
public class Mail {

	public Mail(String reciever, String sender, String title, String text, Date dateSubmitted) {
		super();
		this.reciever = reciever;
		this.sender = sender;
		this.title = title;
		this.text = text;
		this.dateSubmitted = dateSubmitted;
	}

	public Mail() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mailSequence")
	@SequenceGenerator(allocationSize = 1, name = "mailSequence", sequenceName = "SQ_M_PK")
	@Column(name = "M_ID")
	private int id;

	@Column(name = "M_RECEIVER")
	private String reciever;

	@Column(name = "M_SENDER")
	private String sender;

	@Column(name = "M_TITLE")
	private String title;

	@Column(name = "M_TEXT")
	private String text;

	@Column(name = "M_SUBMITTED")
	private Date dateSubmitted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Mail [id=" + id + ", reciever=" + reciever + ", sender=" + sender + ", title=" + title + ", text="
				+ text + ", dateSubmitted=" + dateSubmitted + "]";
	}

}
