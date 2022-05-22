package com.examples.java.day8;

import org.w3c.dom.ls.LSOutput;

class InsufficientFund extends Exception{
    public InsufficientFund(){
        System.out.println("Insufficient fund");
    }

        }
class Bank {

    int bal =0;
    int acctNum;
    public Bank(int acctNum){
        this.acctNum = acctNum;
    }
    public void deposit(int amount)  {
        bal = bal+ amount;
        System.out.println("amount credited: " + amount);
        System.out.println("current balance: " + bal);
        }
    public void withdraw(int amt) throws InsufficientFund {
        if(amt<=bal){
            bal=bal-amt;
            System.out.println("amount debited - " + amt);

        }
        else{
            throw new InsufficientFund();
        }
        }
        }

public class Demo3 {
    public static void main(String[] args) {
        Bank bank1  = new Bank(123456);

        bank1.deposit(1000);
       try {
        bank1.withdraw(500);}
       catch (InsufficientFund i){};

    }
}
