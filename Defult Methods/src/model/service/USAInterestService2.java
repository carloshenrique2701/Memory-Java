package model.service;

import model.interfaces.InterestService;

public class USAInterestService2 implements InterestService {

	private Double interestRate;

	public USAInterestService2(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

}
