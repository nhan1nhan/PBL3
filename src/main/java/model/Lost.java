package model;

import java.sql.Date;

public class Lost {
  private int idLost;
  private Barn barn;
  private User user;
  private Date date;
  private int number;
  private String reason;
  
  public Lost() {}

  public Lost(int idLost, Barn barn, User user, Date date, int number, String reason) {
	super();
	this.idLost = idLost;
	this.barn = barn;
	this.user = user;
	this.date = date;
	this.number = number;
	this.reason = reason;
}

public int getIdLost() {
	return idLost;
}

public void setIdLost(int idLost) {
	this.idLost = idLost;
}

public Barn getBarn() {
	return barn;
}

public void setBarn(Barn barn) {
	this.barn = barn;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getNumber() {
	return number;
}

public void setNumber(int number) {
	this.number = number;
}

public String getReason() {
	return reason;
}

public void setReason(String reason) {
	this.reason = reason;
}
  

  
}
