package com.atomicity.dao;

import com.atomicity.domain.ProfilePics;

public interface PPDAO {

	public void push(ProfilePics newPic);

	public ProfilePics getPicByName(String username);

}
