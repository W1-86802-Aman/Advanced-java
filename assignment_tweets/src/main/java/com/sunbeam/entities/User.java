package com.sunbeam.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="tweets")
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String firstname;
 private String lastname;
 private String email;
 private String password;
 
 @OneToMany(mappedBy="user")
 private List<Tweet> tweets;
 
}
