package com.model;

public class User {
	private int id;
	private String userName;
	private String password;
	private String email;
	private int rank;
	private float salary;
	private boolean registered;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userName
	 * @param password
	 * @param email
	 * @Description:注册时使用的构造函数
	 */
	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	/**
	 * @param userName
	 * @param password
	 * @Description:登陆时使用的构造函数
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param email
	 * @param rank
	 * @param salary
	 * @param registered
	 * @Description:完整的构造函数
	 */
	public User(String userName, String password, String email, float salary, boolean registered) {
		super();
//		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
//		this.rank = rank;
		this.salary = salary;
		this.registered = registered;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
}
