package com.example.mortgagecalculator;

public class Mortgage {
	private int id;
	private double purchasePrice;
	private double downPayment;
	private double mortgageTerm;
	private double interestRate;
	private double tax;
	private double insurance;
	private String zip;
	private String monthChoice;
	private String yearChoice;
	private String monthPayment;
	private String totalPayment;
	private String payOffDate;
	private String firstPayDate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Mortgage(double purchasePrice, double downPayment,double mortgageTerm,double interestRate,
			       double tax, double insurance,String zip, String monthChoice, String yearChoice,
			       String monthPayment, String totalPayment, String payOffDate){
		this.purchasePrice = purchasePrice;
		this.downPayment = downPayment;
		this.mortgageTerm = mortgageTerm;
		this.interestRate = interestRate;
		this.tax = tax;
		this.insurance = insurance;
		this.zip = zip;
		this.monthChoice = monthChoice;
		this.yearChoice = yearChoice;
		this.monthPayment = monthPayment;
		this.totalPayment = totalPayment;
		this.payOffDate = payOffDate;
		this.firstPayDate = monthChoice+" "+yearChoice;
		
	}
	
	public Mortgage(){
		
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	public double getMortgageTerm() {
		return mortgageTerm;
	}
	public void setMortgageTerm(double mortgageTerm) {
		this.mortgageTerm = mortgageTerm;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getInsurance() {
		return insurance;
	}
	public void setInsurance(double insurance) {
		this.insurance = insurance;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMonthChoice() {
		return monthChoice;
	}
	public void setMonthChoice(String monthChoice) {
		this.monthChoice = monthChoice;
	}
	public String getYearChoice() {
		return yearChoice;
	}
	public void setYearChoice(String yearChoice) {
		this.yearChoice = yearChoice;
	}
	public String getMonthPayment() {
		return monthPayment;
	}
	public void setMonthPayment(String monthPayment) {
		this.monthPayment = monthPayment;
	}
	public String getTotalPayment() {
		return totalPayment;
	}
	public void setTotalPayment(String totalPayment) {
		this.totalPayment = totalPayment;
	}
	public String getPayOffDate() {
		return payOffDate;
	}
	public void setPayOffDate(String payOffDate) {
		this.payOffDate = payOffDate;
	}
	public String getFirstPayDate() {
		return firstPayDate;
	}
	public void setFirstPayDate(String firstPayDate) {
		this.firstPayDate = firstPayDate;
	}
	
	public String toString(){
		return "Mortgage [id= "+id+" , purchase price "+purchasePrice+" , down payment "+downPayment+" , mortgage term "
				           +mortgageTerm+" , interest rate "+interestRate+" , property tax "+tax+" , property insurance "+
				           insurance+" , ZIP code "+zip+" , first pay date "+firstPayDate+" , monthly payment "+monthPayment+
				           " , total payment "+totalPayment+" , pay-off date "+payOffDate+" ]";
				
				
		
	}
	
	
}
