package model.Imp;



import model.LoanInitial;


public class HousingLoan extends LoanInitial{
	
	private double annualInterestRate;
	
	private double monthlyPayment;
	
	private double totalInterest;
	
	private double totalPayment;
	
	public HousingLoan(double annualInterestRate) {
		
		super(annualInterestRate);
		
		this.annualInterestRate=annualInterestRate;
	}
	
	public HousingLoan() {}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	public double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public double calMonthlyPayment(){
		
		int months = getTerms()*12;
		double rate =this.annualInterestRate/1200;
		monthlyPayment = getPrincipal() * rate / (1 - 1/Math.pow(1 + rate, months));
		monthlyPayment = Math.round(monthlyPayment * 100);
		monthlyPayment = monthlyPayment/100;
		return monthlyPayment;
		
	}

}
