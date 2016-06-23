package com.test.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.rest.domain.Post;
import com.test.rest.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	/**
	 * Get post by Id, save it, and populate Posts table
	 */
	@RequestMapping(value = { "/" })
	public String openPage(HttpServletRequest request, Model model) {
		String postId = request.getParameter("postid");
		if (postId != null && !postId.isEmpty()) {
			Post post = postService.getPostById(postId);
			postService.savePost(post);
		}
		model.addAttribute("posts", postService.getAllPosts());
		return "index";
	}

}
