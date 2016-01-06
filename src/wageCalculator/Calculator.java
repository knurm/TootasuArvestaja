package wageCalculator;

public class Calculator {
	
	private double unempTaxEmplyPercent = 0.016;
	private double incomeTacPercent = 0.2;
	private double socialTaxPercent = 0.33;
	private double unempTaxEmplyrPercent = 0.008;
	
	public double grossPay (double hourlyPay, double workedHours) {
		return hourlyPay * workedHours;
	}
	
	public double unempTaxEmply (double grossPay) {
		return grossPay * unempTaxEmplyPercent;
	}
	
	public double fundedPensionTax (double grossPay, double fundedPension) {
		return grossPay * fundedPension;
	}
	
	public double incomeTax (double grossPay, double unempTaxEmply, double fundedPension, double taxFreeMin) {
		return (grossPay - taxFreeMin - unempTaxEmply - fundedPension) * incomeTacPercent;
	}
	
	public double netPay (double grossPay, double incomeTax, double unempTaxEmply, double fundedPension) {
		return grossPay - incomeTax - unempTaxEmply - fundedPension;
	}
	
	public double socialTax (double grossPay) {
		return grossPay * socialTaxPercent;
	}
	
	public double unempTaxEmplyr (double grossPay) {
		return grossPay * unempTaxEmplyrPercent;
	}
}
