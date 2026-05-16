package Entity;

public class Account {

	private int accountNumber;
	private String name;
	private double balance;

	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public Account(int accountNumber, String name, double initialDeposit) {
		this.accountNumber = accountNumber;
		this.name = name;
		newDeposit(initialDeposit);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void newDeposit(double value) {
		this.balance += value;
	}

	public void newWithdraw(double value) {
		this.balance -= value + 5;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String toString() {
		return String.format("Account [accountNumber= %d, name= %s, balance= %.2f]", accountNumber, name, balance);
	}

}
