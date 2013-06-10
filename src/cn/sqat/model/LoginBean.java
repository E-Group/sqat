package cn.sqat.model;

//Data Encapsulation using Getters and Setters
public class LoginBean {
	private String id;
	private String username;
	private String password;
	public boolean valid;
	public boolean gunner;

	public String getId()
	{
		return id;
	}
	public void setId(int newId)
	{
		id = String.valueOf(newId);
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String newPassword)
	{
		password = newPassword;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUserName(String newUsername)
	{
		username = newUsername;
	}
	public boolean isValid()
	{
		return valid;
	}
	public void setValid(boolean newValid)
	{
		valid = newValid;
	}
	public boolean isGunner() {
		return gunner;
	}
	public void setGunner(boolean gunner) {
		this.gunner = gunner;
	}
}
