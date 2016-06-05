package model;

public class LoanInitial implements Loan {
	
	private double annualInterestRate;

	private String loanType;
	
	private double principal;
	
	private int terms;

	public LoanInitial(){
		
	}
	public LoanInitial(double annualInterestRate){
		
		this.annualInterestRate = annualInterestRate;
	}
	
	public double getAnnualInterestRate() {
		
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double annualInterestRate) {
		
		this.annualInterestRate = annualInterestRate;
	}
	
	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public int getTerms() {
		return terms;
	}

	public void setTerms(int terms) {
		this.terms = terms;
	}

	public double calMonthlyPayment(){
		return 0.0;
	}
	

}
