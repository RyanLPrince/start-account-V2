package com.qa.domain;


import javax.persistence.*;

@Entity 
public class Account {
	
	@Column(length=40)
	private String firstName;
	@Column(length=40)
	private String secondName;
	@Id @GeneratedValue() 
	private long id;
	private long accountNumber;

	public Account(String firstName, String secondName, long accountNumber) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public long getId() {
		return id;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
