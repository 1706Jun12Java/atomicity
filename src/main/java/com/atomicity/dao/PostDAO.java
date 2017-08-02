
package com.atomicity.dao;

import java.util.List;
import com.atomicity.domain.Post;

public interface PostDAO {

	public List<Post> getAllPosts();

	public void push(Post post);
}