package com.example.mortgagecalculator;

import java.util.LinkedHashMap;

public class Calculate {
	
		private double monthlyPayment;
		private double totalPayment;
		private double monthRate;
		private double monthTerm;
		private double monthTax;
		private double monthInsurance;
		private String date;
		private LinkedHashMap<String, String> monthMap;
		
		
		public double calculateMonthlyPayment(double purchasePrice, double downPayment, double mortgageTerm,
				                               double interestRate, double tax, double insurance){
			monthRate = interestRate/100/12;
			monthTerm = calculateMonthTerm(mortgageTerm);
			double a = 1+monthRate;
			double b = Math.pow(a, monthTerm);
			monthTax = tax/12;
			monthInsurance = insurance/12;
			monthlyPayment =monthTax+monthInsurance+ (purchasePrice*(1-downPayment/100)*monthRate*b)/(b-1);
			totalPayment = monthlyPayment*monthTerm;
			return monthlyPayment;	
					
		}
		
		public double calculateTotalPayment(double monthlyPayment){
			totalPayment = monthlyPayment*monthTerm;
			return totalPayment;
		}
		
		public double calculateMonthTerm(double mortgageTerm){
			monthTerm = mortgageTerm*12;
			return monthTerm;
		}
		
		public String calculateDate(String month, String year ,double mortgageTerm){
			monthMap = new LinkedHashMap<String, String>();
			monthMap.put("Jan", "Dec");
			monthMap.put("Feb", "Jan");
			monthMap.put("Mar", "Feb");
			monthMap.put("Apr", "Mar");
			monthMap.put("May", "Apr");
			monthMap.put("Jun", "May");
			monthMap.put("Jul", "Jun");
			monthMap.put("Aug", "Jul");
			monthMap.put("Sep", "Aug");
			monthMap.put("Oct", "Sep");
			monthMap.put("Nov", "Oct");
			monthMap.put("Dec", "Nov");
			String mon = monthMap.get(month);
			double yearDouble = Double.parseDouble(year);
			double dateDouble = yearDouble+mortgageTerm;
			
		    date = mon+" , "+String.format("%.0f",dateDouble);
			return date;
			
			
			
		
			
			}
			
			
		
	}		