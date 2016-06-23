package com.test.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.rest.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
