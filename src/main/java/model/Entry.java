package model;

import java.sql.Date;

public class Entry {
  private int idEntry;
  private Barn barn;
  private Date date;
  private int number;
  private User user;
  
  
public Entry() {}  
  
public Entry(int idEntry, Barn barn, Date date, int number, User user) {
	super();
	this.idEntry = idEntry;
	this.barn = barn;
	this.date = date;
	this.number = number;
	this.user = user;
}

public int getIdEntry() {
	return idEntry;
}

public void setIdEntry(int idEntry) {
	this.idEntry = idEntry;
}

public Barn getbarn() {
	return barn;
}

public void setbarn(Barn barn) {
	this.barn = barn;
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

public User getuser() {
	return user;
}

public void setuser(User user) {
	this.user = user;
}
 
}
