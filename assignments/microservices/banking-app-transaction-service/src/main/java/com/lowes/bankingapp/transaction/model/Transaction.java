package com.lowes.bankingapp.transaction.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotEmpty
	String type	;
	String description;
	@PositiveOrZero
	double amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountid", referencedColumnName = "id")
	Account accountId;
	
	@Column(name = "transactiontime", columnDefinition = "TIMESTAMP")
	LocalTime transactionTime;
	String status;
	String ftid;
	
	
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Account getAccountId() {
		return accountId;
	}
	public void setAccountId(Account accountId) {
		this.accountId = accountId;
	}
	public LocalTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
   

	public Transaction(int id, String type, String description, double amount, Account accountId,
			LocalTime transactionTime, String status, String ftid) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.accountId = accountId;
		this.transactionTime = transactionTime;
		this.status = status;
		this.ftid = ftid;
	}
	public Transaction() {
		super();
	}
	
	
	
	
}