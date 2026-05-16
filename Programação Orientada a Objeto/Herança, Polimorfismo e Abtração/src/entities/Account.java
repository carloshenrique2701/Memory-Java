package entities;

public abstract class Account {

	private Integer namber;
	private String holder;
	protected Double balance;

	public Account() {
	}

	public Account(Integer namber, String holder, Double balance) {
		this.namber = namber;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNamber() {
		return namber;
	}

	public void setNamber(Integer namber) {
		this.namber = namber;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(Double amount) {
		this.balance += amount;
	}

	public void withdraw(Double amount) {
		this.balance -= amount + 5.0;
	}

}
