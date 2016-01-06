package wageCalculator;

public class Employee {
	
	public Employee(String firstName, String surName, double personalCode, double taxFreeMin, double fundedPension, double hourlyPay) {
		firstName = firstName;
		surName = surName;
		personalCode = personalCode;
		taxFreeMin = taxFreeMin;
		fundedPension = fundedPension;
		hourlyPay = hourlyPay;
	}
	
	public class EmployeeInfo {
		private String firstName;
		private String surName;
		private String personalCode;
		private double hourlyPay;
		private double taxFreeMin;
		private double fundedPension;
		
		@Override
		public String toString() {
			return super.toString();
		}
		
		public EmployeeInfo(String firstName, String surName, double hourlyPay, double taxFreeMin, double fundedPension) {
			this.firstName = firstName;
			this.surName = surName;
			this.hourlyPay = hourlyPay;
			this.taxFreeMin = taxFreeMin;
			this.fundedPension = fundedPension;
		}
	}

}
