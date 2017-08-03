package com.atomicity.domain;

import java.util.Date;
import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllTopics", query = "FROM Topic"),
		@NamedQuery(name = "getAllTopicsByCategory", query = "FROM Topic WHERE category = :var ORDER BY dateSubmitted DESC") })

@Entity
@Table(name = "A_TOPICS")
public class Topic {

	public Topic(String author, String category, Date dateSubmitted, String title, String firstPost) {
		super();
		this.author = author;
		this.category = category;
		this.dateSubmitted = dateSubmitted;
		this.title = title;
		this.firstPost = firstPost;
	}

	public Topic(int id, String author, String category, Date dateSubmitted, String title, String firstPost) {
		super();
		this.id = id;
		this.author = author;
		this.category = category;
		this.dateSubmitted = dateSubmitted;
		this.title = title;
		this.firstPost = firstPost;
	}

	public Topic() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topicPicsSequence")
	@SequenceGenerator(allocationSize = 1, name = "topicPicsSequence", sequenceName = "SQ_T_PK")
	@Column(name = "T_ID")
	private int id;

	@Column(name = "T_AUTHOR")
	private String author;

	@Column(name = "T_CATEGORY")
	private String category;

	@Column(name = "T_SUBMITTED")
	private Date dateSubmitted;

	@Column(name = "T_TITLE")
	private String title;

	@Column(name = "T_FIRST_POST")
	private String firstPost;

	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getFirstPost() {
		return firstPost;
	}

	public void setFirstPost(String firstPost) {
		this.firstPost = firstPost;
	}

	public String getUrl() {
		return url;
	}

	public void generateURL() {
		this.url = "";
		this.url += "/Atomicity/Topic/";
		this.url += this.getId() + "/";
		this.url += this.getTitle().replaceAll(" ", "-");
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", author=" + author + ", category=" + category + ", dateSubmitted=" + dateSubmitted
				+ ", title=" + title + ", firstPost=" + firstPost + ", url=" + url + "]";
	}
}