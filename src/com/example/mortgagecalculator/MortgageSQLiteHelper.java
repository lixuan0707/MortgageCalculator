package com.example.mortgagecalculator;

import java.util.LinkedList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MortgageSQLiteHelper extends SQLiteOpenHelper {
	
	private static final int dataBaseVersion = 1;
	private static final String dataBaseName = "MortgagePaymentDataBase";
	private static final String table_name = "MortgagePayment";
	
	private static final String columnId = "id" ;
	private static final String columnPurchasePrice = "PurchasePrice";
	private static final String columnDownPayment = "DownPayment";
	private static final String columnMortgageTerm = "Mortgageterm";
	private static final String columnInterestRate = "InterestRate";
	private static final String columnTax = "PropertyTax";
	private static final String columnPropertyInsurance = "propertyInsurance";
	private static final String columnZip = "ZipCode";
	private static final String columnFirstPayDate = "FirstpaymentDate";
	private static final String columnPayOffDate = "PayoffDate";
	private static final String columnMonthPayment = "MonthlyPayment";
	private static final String columnTotalPayment = "TotalPayment";
	private static final String[] columns = {columnId, columnPurchasePrice, columnDownPayment, columnMortgageTerm,
		                                    columnInterestRate, columnTax, columnPropertyInsurance, columnZip,
	                                    columnFirstPayDate, columnMonthPayment, columnTotalPayment,columnPayOffDate};
	



	public MortgageSQLiteHelper(Context context) {
		super(context, dataBaseName, null, dataBaseVersion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// TODO Auto-generated method stub
		
		String createTable = "CREATE TABLE "+table_name+" ( "+columnId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
		                    columnPurchasePrice+" REAL, "+columnDownPayment+" REAL, "+columnMortgageTerm+" REAL, "
		                    +columnInterestRate+" REAL, "+columnTax+" REAL, "+columnPropertyInsurance+" REAL, "+
		                    columnZip+" TEXT, "+columnMonthPayment+" TEXT, "+columnTotalPayment+" TEXT, "+columnFirstPayDate+" TEXT, "+columnPayOffDate+" TEXT )";
		db.execSQL(createTable);
	} 

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+table_name);
		onCreate(db);
		
	}
	
	public void addMortgage(Mortgage mortgage){
		Log.d("add Mortgage", mortgage.toString());
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		
		values.put(columnPurchasePrice, mortgage.getPurchasePrice());
		values.put(columnDownPayment, mortgage.getDownPayment());
		values.put(columnMortgageTerm, mortgage.getMortgageTerm());
		values.put(columnInterestRate, mortgage.getInterestRate());
		values.put(columnTax, mortgage.getTax());
		values.put(columnPropertyInsurance, mortgage.getInsurance());
		values.put(columnZip, mortgage.getZip());
		values.put(columnMonthPayment, mortgage.getMonthPayment());
		values.put(columnTotalPayment, mortgage.getTotalPayment());
		values.put(columnFirstPayDate, mortgage.getFirstPayDate());
		values.put(columnPayOffDate, mortgage.getPayOffDate());
		
		db.insert(table_name, null, values);
		db.close();
	}
	
	public Mortgage getMortgage(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(table_name,columns, "id = ?", new String[] {String.valueOf(id)},
				                 null, null, null,null);
		if(cursor !=null)
			cursor.moveToFirst();
		
		Mortgage mort = this.cursorToMortgage(cursor);
		Log.d("getMortgage("+ id+" )", mort.toString() );
		return mort;
				
	}
	
	private Mortgage cursorToMortgage(Cursor cursor){
		Mortgage mort = new Mortgage();
		
		mort.setId(Integer.parseInt(cursor.getString(0)));
		mort.setPurchasePrice(cursor.getDouble(1));
		mort.setDownPayment(cursor.getDouble(2));
		mort.setMortgageTerm(cursor.getDouble(3));
		mort.setInterestRate(cursor.getDouble(4));
		mort.setTax(cursor.getDouble(5));
		mort.setInsurance(cursor.getDouble(6));
		mort.setZip(cursor.getString(7));
		mort.setFirstPayDate(cursor.getString(8));
		mort.setMonthPayment(cursor.getString(9));
		mort.setTotalPayment(cursor.getString(10));
		mort.setPayOffDate(cursor.getString(11));
		return mort;
		
		
		
		
	}
	
	public LinkedList<Mortgage> getAllMortgage(){
		LinkedList<Mortgage> mortgages = new LinkedList<Mortgage>();
		String query = "SELECT * FROM "+table_name;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Mortgage mort = null;
		if(cursor.moveToFirst()){
			do{
				 mort = this.cursorToMortgage(cursor);
				 mortgages.add(mort);
				 cursor.moveToNext();
			}while(!cursor.isAfterLast());
			
			
			}
		Log.d("get all mortgages",mortgages.toString());
		return mortgages;
		
		
		
	}

}
