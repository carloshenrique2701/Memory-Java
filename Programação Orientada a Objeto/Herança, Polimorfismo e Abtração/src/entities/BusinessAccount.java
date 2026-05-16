package entities;

public class BusinessAccount extends Account {

	private Double loanLimit;

	public BusinessAccount() {
	}

	public BusinessAccount(Integer namber, String holder, Double balance, Double loanLimit) {
		super(namber, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10;
		}
	}
	
	@Override
	public void withdraw(Double amount) {
		super.withdraw(amount);
		balance -= 2;
	}
	
}
