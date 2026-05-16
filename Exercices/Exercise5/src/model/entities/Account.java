package model.entities;

import model.exceptions.NewAccountException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	
	public void withdraw(double value) throws NewAccountException {
		
		if (value > withdrawLimit) {
			throw new NewAccountException("The amout exceeds withdraw limit.");
		} 
		if (balance <= 0|| value > balance) {
			throw new NewAccountException("Not enough balance.");
		}
		
		balance -= value;
		
	}
	
}
