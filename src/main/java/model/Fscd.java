package model;

import java.sql.Date;

public class Fscd {
  private int idFcsd;
  private Date date;
  private int weight;
  private User user;
  private Food food;
  
public Fscd() {}

public Fscd(int idFcsd, Date date, int weight, User user, Food food) {
	super();
	this.idFcsd = idFcsd;
	this.date = date;
	this.weight = weight;
	this.user = user;
	this.food = food;
}

public int getIdFcsd() {
	return idFcsd;
}

public void setIdFcsd(int idFcsd) {
	this.idFcsd = idFcsd;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getWeight() {
	return weight;
}

public void setWeight(int weight) {
	this.weight = weight;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Food getFood() {
	return food;
}

public void setFood(Food food) {
	this.food = food;
}  
  
  


 
	
}
