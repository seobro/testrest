package com.test.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.rest.domain.Post;
import com.test.rest.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	/**
	 * Populate Posts table and open index page
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String openPage(Model model) {
		model.addAttribute("posts", postService.getAllPosts());
		return "index";
	}

	/**
	 * Get post by Id and update Posts table
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String getPostById(Model model, HttpServletRequest request) {
		String postId = request.getParameter("postid");
		if (postId != null && !postId.isEmpty()) {
			Post post = postService.getPostById(postId);
			postService.savePost(post);
		}
		model.addAttribute("posts", postService.getAllPosts());
		return "index";
	}

}
