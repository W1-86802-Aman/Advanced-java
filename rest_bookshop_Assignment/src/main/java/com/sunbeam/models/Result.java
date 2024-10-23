package com.sunbeam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

enum Status{
  sucess,error	
}
@JsonInclude(Include.NON_NULL) // will not show the empty fields which are null on success and error
public class Result {
   private Status status;
   private String message;
   private Object data;
   @JsonIgnore //ingores the field doesnt show it to end user
   private String remarks;
public Result(Status status, String message, Object data) {
	
	this.status = status;
	this.message = message;
	this.data = data;
//	this.remarks = remarks;
}
public Status getStatus() {
	return status;
}
public void setStatus(Status status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
   
public static Result success(Object data) {
	return new Result(Status.sucess, null, data);
}

public static Result error(String message) {
	return new Result(Status.error, message,null);
}
   
}
