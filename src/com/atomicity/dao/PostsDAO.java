package com.atomicity.dao;

import java.util.List;
import com.atomicity.domain.Posts;

public interface PostsDAO {

	public List<Posts> getAllPosts();

	public void push(Posts post);
}
