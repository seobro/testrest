package com.test.rest.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.rest.domain.Post;
import com.test.rest.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	private static String postsURL = "http://jsonplaceholder.typicode.com/posts/";

	/**
	 * Get post by Id from typicode.com service
	 * 
	 * @param postId
	 */
	public Post getPostById(String postId) {
		ObjectMapper mapper = new ObjectMapper();
		Post post = null;
		try {
			post = mapper.readValue(new URL(postsURL + postId), Post.class);
		} catch (IOException e) {
			System.err.println("Getting post by Id=" + postId + " exception: " + e.getMessage());
		}
		return post;
	}

	/**
	 * Save post to the database
	 * 
	 * @param post - Post entity
	 */
	public void savePost(Post post) {
		if (post != null) {
			postRepository.save(post);
		}
	}

	/**
	 * Retrieve all posts from database
	 */
	public List<Post> getAllPosts() {
		return (List<Post>) postRepository.findAll();
	}
}
