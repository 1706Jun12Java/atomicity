package com.atomicity.domain;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({ @NamedQuery(name = "getAllPosts", query = "FROM Post"),
		@NamedQuery(name = "getPostByUsername", query = "FROM Post WHERE username = :var") })

@Entity
@Table(name = "A_POSTS")
public class Post {

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
	private String username;

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

	public String getUsername() {
		return username;
	}

	public Post setUsername(String username) {
		this.username = username;
		return this;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public Post setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
		return this;
	}
}