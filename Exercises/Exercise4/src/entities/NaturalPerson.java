package entities;

public class NaturalPerson extends Entity {

	private Double healthCosts;

	public NaturalPerson() {

	}

	public NaturalPerson(String name, Double annualIncome, Double healthCosts) {
		super(name, annualIncome);
		this.healthCosts = healthCosts;
	}

	public Double getHealthCosts() {
		return healthCosts;
	}

	public void setHealthCosts(Double healthCosts) {
		this.healthCosts = healthCosts;
	}

	@Override
	public double calcTaxes() {

		double halthCostsTaxes = (getHealthCosts() * 0.50);

		if (getAnnualIncome() > 20000.0) {
			return (getAnnualIncome() * 0.25) - halthCostsTaxes;
		} else {
			return (getAnnualIncome() * 0.15) - halthCostsTaxes;
		}
		
	}

}
