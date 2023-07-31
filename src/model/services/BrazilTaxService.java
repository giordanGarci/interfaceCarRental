package model.services;

public class BrazilTaxService implements TaxService {


	public Double tax(Double amount) {
		double taxMultiplier = (amount <= 100) ? 0.2 : 0.15;
		return amount * taxMultiplier;
	}
}
