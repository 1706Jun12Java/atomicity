package com.atomicity.domain;

import java.util.Date;
import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllTopics", query = "FROM Topic") })

@Entity
@Table(name = "A_TOPICS")
public class Topic {

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

	public int getId() {
		return id;
	}

	public Topic setId(int id) {
		this.id = id;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Topic setAuthor(String author) {
		this.author = author;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public Topic setCategory(String category) {
		this.category = category;
		return this;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public Topic setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
		return this;

	}

}