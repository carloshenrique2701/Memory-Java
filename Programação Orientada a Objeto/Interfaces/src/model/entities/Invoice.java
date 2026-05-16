package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;

	public Invoice() {

	}

	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPaymente() {
		return basicPayment;
	}

	public void setBasicPaymente(Double basicPaymente) {
		this.basicPayment = basicPaymente;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return getBasicPaymente() + getTax();
	}

}
