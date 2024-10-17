package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.Bookdao;
import com.sunbeam.entities.Book;

public class SubjectsBean {
  private List<String> subjects;
  public SubjectsBean() {
	  this.subjects=new ArrayList<String>();
  }
public List<String> getSubjects() {
	return subjects;
}
public void setSubjects(List<String> subjects) {
	this.subjects = subjects;
}
  public void fetchSubjects() {
	  try(Bookdao bookDao = new Bookdao()){
		 this.subjects= bookDao.findAllSubject();
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
