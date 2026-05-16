package model.entities;

import java.time.LocalDate;

public class Contract {

	private Integer number;
	private LocalDate initData;
	private Double totalValue;
	private Double valuePerInstallment;
	private Integer installments;

	public Contract() {

	}

	public Contract(Integer number, LocalDate initData, Double totalValue, Integer installments) {
		this.number = number;
		this.initData = initData;
		this.totalValue = totalValue;
		this.installments = installments;
		this.valuePerInstallment = totalValue / installments; 
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getInitData() {
		return initData;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double value) {
		this.totalValue = value;
	}

	public Integer getInstallments() {
		return installments;
	}

	public Double getValuePerInstallment() {
		return valuePerInstallment;
	}

	

}
