package com.example.mortgagecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayResultActivity extends Activity{
	private TextView monthlyPayment;
	private TextView totalPayment;
	private TextView payOffDate;
	private TextView monthNums;
	private double  purchasePrice;
	private double downPayment;
	private double mortgageTerm;
    private double interestRate;
    private double tax;
    private double insurance;
    private double zip;
    private String monthChoice;
    private String yearChoice;
    private double monthPayRes;
    private double totalPayRes;
    private double monthTerm;
    private String date;
    private String firstPayDate;
 
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.result);
 
        Bundle bundle = getIntent().getExtras();
        monthlyPayment = (TextView) findViewById(R.id.monthpayRestextView);
        totalPayment = (TextView) findViewById(R.id.totalResulttextView);
        payOffDate = (TextView) findViewById(R.id.dateResulttextView);
        monthNums = (TextView)findViewById(R.id.totalPaymenttextView); 
        
        
        
        
        purchasePrice = Double.parseDouble(bundle.getString("purchasePrice")); 
        downPayment = Double.parseDouble(bundle.getString("downPayment")); 
        mortgageTerm = Double.parseDouble(bundle.getString("mortgageTerm")); 
        interestRate = Double.parseDouble(bundle.getString("interestRate")); 
        tax = Double.parseDouble(bundle.getString("tax")); 
        insurance = Double.parseDouble(bundle.getString("insurance")); 
        zip = Double.parseDouble(bundle.getString("zipCode"));
        monthChoice =(String) bundle.getString("monthChoice");
        yearChoice =(String) bundle.getString("yearChoice");
        firstPayDate = monthChoice+","+yearChoice;
        
        Calculate cal = new Calculate();
        monthPayRes = cal.calculateMonthlyPayment(purchasePrice, downPayment,
        		                               mortgageTerm, interestRate, tax, insurance);
        totalPayRes = cal.calculateTotalPayment(monthPayRes);
        
        monthTerm = cal.calculateMonthTerm(mortgageTerm);
        
        date = cal.calculateDate(monthChoice, yearChoice, mortgageTerm);
        
        monthlyPayment.setText(String.format("%.02f",monthPayRes));
        totalPayment.setText(String.format("%.02f",totalPayRes));
        monthNums.setText("Total of "+String.format("%.0f",monthTerm)+ " months payments :");
        payOffDate.setText(date);
        
        Mortgage mort = new Mortgage();
        
		mort.setPurchasePrice((int)purchasePrice);
		mort.setDownPayment(downPayment);
		mort.setMortgageTerm(mortgageTerm);
		mort.setInterestRate(interestRate);
		mort.setTax(tax);
		mort.setInsurance(insurance);
		mort.setZip(String.format("%.0f",zip));
		mort.setFirstPayDate(firstPayDate);
		mort.setMonthPayment(String.format("%.02f",monthPayRes));
		mort.setTotalPayment(String.format("%.02f",totalPayRes));
		mort.setPayOffDate(date);
		Log.d("test",mort.toString());
		
        
		MortgageSQLiteHelper mortSQLiteHelper = new MortgageSQLiteHelper(this);
        
        mortSQLiteHelper.addMortgage(mort);
        mortSQLiteHelper.getMortgage(1);
        mortSQLiteHelper.getAllMortgage();
        
        
      
       
        
 

    }
	

}
