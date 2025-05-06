package model;

public class User {
  private int idUser;
  private String name;
  private String user;
  private String password;
  private boolean status;
  private boolean decent;
  
  
   public User() {}
  
	public User(int idUser, String name, String user, String password, boolean status, boolean decent) {
		this.idUser = idUser;
		this.name = name;
		this.user = user;
		this.password = password;
		this.status = status;
		this.decent = decent;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isDecent() {
		return decent;
	}

	public void setDecent(boolean decent) {
		this.decent = decent;
	}
	
	
  
  
}
