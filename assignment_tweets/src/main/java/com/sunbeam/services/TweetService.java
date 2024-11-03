package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.Tweet;

public interface TweetService {

	List<Tweet> findAll();

	List<Tweet> findByHashtag(String hashtag);

//	Tweet findByHashtag(String hashtag);

}
