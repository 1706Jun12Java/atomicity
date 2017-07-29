package com.atomicity.domain;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllPics", query = "FROM ProfilePics"),
		@NamedQuery(name = "getPicsByUsername", query = "FROM ProfilePics WHERE username = :var") })

@Entity
@Table(name = "A_PROFILE_PICS")
public class ProfilePics {

	public ProfilePics() {
		super();
	}

	public ProfilePics(String username, byte[] pic) {
		super();
		this.username = username;
		this.pic = pic;
	}

	public ProfilePics(int id, String username, byte[] pic) {
		super();
		this.id = id;
		this.username = username;
		this.pic = pic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profilePicsSequence")
	@SequenceGenerator(allocationSize = 1, name = "profilePicsSequence", sequenceName = "SQ_PC_PK")
	@Column(name = "PC_ID")
	private int id;

	@Column(name = "PC_USERNAME")
	private String username;

	@Lob
	@Column(name = "PC_PIC")
	private byte[] pic;

	public int getId() {
		return id;
	}

	public ProfilePics setId(int id) {
		this.id = id;
		return this;
	}

	public byte[] getPic() {
		return pic;
	}

	public ProfilePics setPic(byte[] pic) {
		this.pic = pic;
		return this;
	}

}
