package com.sunbeam.entities;

//import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="user")
@Getter
@Setter
@Entity
@Table(name="tweets")
public class Tweet {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private int id;
 private String text;
 private String hashtag;
 private LocalDateTime tweet_datetime;
 @ManyToOne
 @JoinColumn(name="user_id")
 private User user;
 
}
