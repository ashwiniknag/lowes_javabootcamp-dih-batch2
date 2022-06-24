package com.lowes.bankingapp.fundtransfer.model;

import java.rmi.server.UID;
import java.util.UUID;

public class FundTransfer {
	String ftid = UUID.randomUUID().toString();
	int srcAccnt;
	int destAccnt;
	double amount;
	
	
	
	public String getFtid() {
		return ftid;
	}
	public void setFtid(String ftid) {
		this.ftid = ftid;
	}
	public int getSrcAccnt() {
		return srcAccnt;
	}
	public void setSrcAccnt(int srcAccnt) {
		this.srcAccnt = srcAccnt;
	}
	public int getDestAccnt() {
		return destAccnt;
	}
	public void setDestAccnt(int destAccnt) {
		this.destAccnt = destAccnt;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public FundTransfer(String ftid, int srcAccnt, int destAccnt, double amount) {
		super();
		this.ftid = ftid;
		this.srcAccnt = srcAccnt;
		this.destAccnt = destAccnt;
		this.amount = amount;
	}
	public FundTransfer() {
		super();
	}
	
			
}
