package com.atomicity.dao;

import com.atomicity.domain.ProfilePic;

public interface ProfilePicDAO {

	public void push(ProfilePic newPic);

	public ProfilePic getPicByName(String username);

	void update(ProfilePic Pic, byte[] newPic);

}