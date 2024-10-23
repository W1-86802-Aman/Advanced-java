package com.sunbeam.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

enum StatusUser{
	success,error
}
@JsonInclude(Include.NON_NULL)
public class UserResult {
  private StatusUser status;
  private String message;
  private Object data;
  
  public UserResult() {
	  
  }
public UserResult(StatusUser status, String message, Object data) {
	super();
	this.status = status;
	this.message = message;
	this.data = data;
}
public StatusUser getStatus() {
	return status;
}
public void setStatus(StatusUser status) {
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
@Override
public String toString() {
	return "UserResult [status=" + status + ", message=" + message + ", data=" + data + "]";
}
  public static UserResult success(Object data) {
	  return new UserResult(StatusUser.success,null,data);
  }
  public static UserResult error(String message) {
	  return new UserResult(StatusUser.error,message,null);
  }
  
}
