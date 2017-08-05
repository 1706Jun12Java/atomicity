package com.atomicity.domain;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({ @NamedQuery(name = "getAllPosts", query = "FROM Post"),
		@NamedQuery(name = "getPostByUsername", query = "FROM Post WHERE username = :var"),
		@NamedQuery(name = "getAllByTopicId", query = "FROM Post WHERE topicId = :var ORDER BY dateSubmitted ASC") })


@Entity
@Table(name = "A_POSTS")
public class Post {

	public Post() {
		super();
	}

	public Post(int topicId, String text, String username, Date dateSubmitted) {
		super();
		this.topicId = topicId;
		this.text = text;
		this.author = username;
		this.dateSubmitted = dateSubmitted;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postSequence")
	@SequenceGenerator(allocationSize = 1, name = "postSequence", sequenceName = "SQ_PT_PK")
	@Column(name = "PT_ID")
	private int id;

	@Column(name = "PT_T_ID")
	private int topicId;

	@Column(name = "PT_TEXT")
	private String text;

	@Column(name = "PT_AUTHOR")
	private String author;


	@Column(name = "PT_SUBMITTED")
	private Date dateSubmitted;

	public int getId() {
		return id;
	}

	public Post setId(int id) {
		this.id = id;
		return this;
	}

	public int getTopicId() {
		return topicId;
	}

	public Post setTopicId(int topicId) {
		this.topicId = topicId;
		return this;
	}

	public String getText() {
		return text;
	}

	public Post setText(String text) {
		this.text = text;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public Post setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
		return this;
	}
}