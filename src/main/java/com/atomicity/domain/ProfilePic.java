package com.atomicity.domain;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllPics", query = "FROM ProfilePic"),
		@NamedQuery(name = "getPicByUsername", query = "FROM ProfilePic WHERE username = :var") })

@Entity
@Table(name = "A_PROFILE_PICS")
public class ProfilePic {

	public ProfilePic() {
		super();
	}

	public ProfilePic(String username, byte[] pic) {
		super();
		this.username = username;
		this.pic = pic;
	}

	public ProfilePic(int id, String username, byte[] pic) {
		super();
		this.id = id;
		this.username = username;
		this.pic = pic;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profilePicSequence")
	@SequenceGenerator(allocationSize = 1, name = "profilePicSequence", sequenceName = "SQ_PC_PK")
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

	public ProfilePic setId(int id) {
		this.id = id;
		return this;
	}

	public byte[] getPic() {
		return pic;
	}

	public ProfilePic setPic(byte[] pic) {
		this.pic = pic;
		return this;
	}

}