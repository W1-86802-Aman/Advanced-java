package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Tweet;
import com.sunbeam.services.TweetService;
import com.sunbeam.services.UserService;

@Controller
public class TweetController {
  @Autowired
  private TweetService tweetService;
  
  @RequestMapping("/tweets")
  public String showTweets(Model model) {
	  List<Tweet> tweet=tweetService.findAll();
	  model.addAttribute("tweets", tweet);
	  return "tweets";
  }
  
//  @GetMapping("/newtweet")
//  public String showNewTweet() {
//	  
//  }
    @GetMapping("/findhashtag_tweet")
    public String showhashtags() {
    	return "findhashtag_tweet";
    }
  
   @PostMapping("/findhashtag_tweet")
   public String findByHashtag(@RequestParam String hashtag,Model model) { 
	   List<Tweet> tweet=tweetService.findByHashtag(hashtag);
	   model.addAttribute("tweets", tweet);
	   return "findhashtag_tweet";
   }
   
   
   
   @RequestMapping("/logout")
   public String leave() {
	   return "logout";
   }
}
