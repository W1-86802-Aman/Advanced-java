package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.daos.TweetDao;
import com.sunbeam.entities.Tweet;
@Transactional
@Service
public class TweetServiceImpl implements TweetService{
    @Autowired
    private TweetDao tweetDao;
    
	@Override
	public List<Tweet> findAll() {
		 List <Tweet> tweet=tweetDao.findAll();
		return tweet;
	}

	@Override
	public List<Tweet> findByHashtag(String hashtag) {
		List<Tweet> list=tweetDao.findByHashtag(hashtag);
		return list;
	}

//	@Override
//	public Tweet findByHashtag(String hashtag) {
//		Tweet tweet=tweetDao.findByHashtag(hashtag);
//		return tweet;
//	}

}
