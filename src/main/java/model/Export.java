package model;

import java.sql.Date;

public class Export {
   private int idExport;
   private Barn barn;
   private Date date;
   private int number;
   private User user;
   
public Export() {}

public Export(int idExport, Barn barn, Date date, int number, User user) {
	super();
	this.idExport = idExport;
	this.barn = barn;
	this.date = date;
	this.number = number;
	this.user = user;
}

public int getIdExport() {
	return idExport;
}

public void setIdExport(int idExport) {
	this.idExport = idExport;
}

public Barn getBarn() {
	return barn;
}

public void setBarn(Barn barn) {
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

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}   
   
   

   
   
}
