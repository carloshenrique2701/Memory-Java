package model.service;

public class PaypalService implements PaymentService {

	@Override
	public double calcInstallment(double amount, int installment) {
		return (amount * (0.01 * installment + 1)) * (0.02 + 1);
	}

}
