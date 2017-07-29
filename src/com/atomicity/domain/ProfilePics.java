package com.atomicity.domain;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "getAllPics", query = "FROM ProfilePics"),
		// Not ready for use
		@NamedQuery(name = "getPicsByUsername", query = "FROM ProfilePics WHERE user.getUsername() = :var") })

@Entity
@Table(name = "A_PROFILE_PICS")
public class ProfilePics {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profilePicsSequence")
	@SequenceGenerator(allocationSize = 1, name = "profilePicsSequence", sequenceName = "SQ_PC_PK")
	@Column(name = "PC_ID")
	private int id;

	@Lob
	@Column(name = "PC_PIC")
	private byte[] pic;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Users user;

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

	public Users getUser() {
		return user;
	}

	public ProfilePics setUser(Users user) {
		this.user = user;
		return this;
	}

}
