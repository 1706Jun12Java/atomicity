package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "A_POST")
public class Posts {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topicPicsSequence")
	@SequenceGenerator(allocationSize = 1, name = "topicPicsSequence", sequenceName = "SQ_PT_PK")
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

	public Posts setId(int id) {
		this.id = id;
		return this;
	}

	public int getTopicId() {
		return topicId;
	}

	public Posts setTopicId(int topicId) {
		this.topicId = topicId;
		return this;
	}

	public String getText() {
		return text;
	}

	public Posts setText(String text) {
		this.text = text;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Posts setAuthor(String author) {
		this.author = author;
		return this;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public Posts setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
		return this;
	}
}
