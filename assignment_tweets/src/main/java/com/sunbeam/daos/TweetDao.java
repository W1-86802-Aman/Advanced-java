package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Tweet;


public interface TweetDao extends JpaRepository<Tweet, Integer>{

	List<Tweet> findByHashtag(String hashtag);

//	Tweet findByHashtag(String hashtag);

}
