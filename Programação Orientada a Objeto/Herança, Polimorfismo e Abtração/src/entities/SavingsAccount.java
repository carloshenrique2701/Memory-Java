package entities;

//Impede que essa classe seja herdada
public final class SavingsAccount extends Account{

	private Double interestRate;
	
	public SavingsAccount() {
		
	}

	public SavingsAccount(Integer namber, String holder, Double balance, Double interestRate) {
		super(namber, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	//Impede que esse metodo seja sobreposto
	@Override
	public final void withdraw(Double amount) {
		balance -= amount;
	}
	
}
