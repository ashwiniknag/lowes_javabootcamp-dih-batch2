package com.lowes.bankingapp.account.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name="account")
public class Account {
	@Id
	@NotNull(message = "Account ID cannot be null or empty.")
	int id;
	@NotEmpty(message = "Account Name cannot be null or empty.")
	@NotNull(message = "Account Name cannot be null or empty.")
	String name;
	String type;
	String status;
	@PositiveOrZero
	double balance;
	//LocalDate openDate;
	
//	{
//		"name": "xyz",
//		"type": "Savings|Current|Loan",
//		"status": "Pending|Active|Closed"
//	}
	
	public Account(int id, String name, String type, String status, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.balance = balance;
	}

	public Account() {
		super();
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
//	public LocalDate getOpenDate() {
//		return openDate;
//	}
//	public void setOpenDate(LocalDate openDate) {
//		this.openDate = openDate;
//	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", balance=" + balance
				+ "]";
	}

	
	
}