package model;

public class Food {
  private int idFood;
  private String name;
  private int price;
  

  public Food() {}
    
  public Food(int idFood, String name, int price) {
	super();
	this.idFood = idFood;
	this.name = name;
	this.price = price;
}

public int getIdFood() {
	return idFood;
}

public void setIdFood(int idFood) {
	this.idFood = idFood;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}
  
  
  
}
