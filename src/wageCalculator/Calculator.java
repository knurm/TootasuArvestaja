package wageCalculator;

public class Calculator {
	
	public static double GrossPay (double hourlyPay, double workedHours) {
		
		return hourlyPay * workedHours;
		
	}
	
	public static double UnempTaxEmply (double grossPay) {
		
		return grossPay * 0.016;
		
	}
	
	public static double FundedPensionTax (double grossPay, double fundedPension) {
		
		return grossPay * fundedPension;
		
	}
	
	public static double IncomeTax (double grossPay, double unempTaxEmply, double fundedPension, double taxFreeMin) {
		
		return (grossPay - taxFreeMin - unempTaxEmply - fundedPension) * 0.2;
		
	}
	
	public static double NetPay (double grossPay, double incomeTax, double unempTaxEmply, double fundedPension) {
		
		return grossPay - incomeTax - unempTaxEmply - fundedPension;
		
	}
	
	public static double SocialTax (double grossPay) {
		
		return grossPay * 0.33;
		
	}
	
	public static double UnempTaxEmplyr (double grossPay) {
		
		return grossPay * 0.008;
		
	}
	
	public static double TaxSum(double[] o, double sumVariable) {
		
		for(int i = 0; i < o.length; i++) {
			
			sumVariable = sumVariable + o[i];
			
		}
		
		return sumVariable;
		
	}
}
