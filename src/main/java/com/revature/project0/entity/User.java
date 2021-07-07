package com.revature.project0.entity;

/*
 * 
 * Table: user
Columns:
id int AI PK
name varchar(45)
accNo int
accBal int
 * 
 * 
 * 
 * 
 * 
 */


public class User {
	
	private int id;
	private String name;
	private int accNo;
	private int accBal;
	
	// constructor for User repository
	
	public User(int id, String name, int accNo, int accBal) {
		super();
		this.id = id;
		this.name = name;
		this.accNo = accNo;
		this.accBal = accBal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAccBal() {
		return accBal;
	}

	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}

	@Override
	public String toString() {
		return "User details : [id=" + id + ", name=" + name + ", accNo=" + accNo + ", accBal=" + accBal + "]";
	}
	
	
	
	

}
