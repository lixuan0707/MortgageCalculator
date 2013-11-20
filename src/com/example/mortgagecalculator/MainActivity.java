package com.example.mortgagecalculator;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemSelectedListener {
	//OnClickListener (inner class, no need to implements)
	
	 EditText priceEditText;  
	private EditText downPayEditText;
	private EditText termEditText;
	private EditText interestRateEditText;
	private EditText taxEditText;
	private EditText insuranceEditText;
	private EditText zipEditText;
	private Spinner monthSpinner;
	private Spinner yearSpinner;
	private Button button;
	private String monthChoice;
	private String yearChoice;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		findAllViewsId();
		
		
		ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(this,R.array.month_arrays,
				                                   android.R.layout.simple_spinner_item);
		monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		monthSpinner.setAdapter(monthAdapter);
		monthSpinner.setOnItemSelectedListener(this);
		
		ArrayAdapter<CharSequence>yearAdapter = ArrayAdapter.createFromResource(this,R.array.year_arrays,
                android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);
        yearSpinner.setOnItemSelectedListener(this);
        
        button.setOnClickListener(new OnClickListener() {           

        	  @Override
        	  public void onClick(View v) 
        	  {
        		  Intent intent = new Intent(getApplicationContext(),DisplayResultActivity.class);
        			Bundle bundle = new Bundle();
        			bundle.putString("purchasePrice",priceEditText.getText().toString());
        			bundle.putString("downPayment",downPayEditText.getText().toString());
        			bundle.putString("mortgageTerm",termEditText.getText().toString());
        			bundle.putString("interestRate",interestRateEditText.getText().toString());
        			bundle.putString("tax",taxEditText.getText().toString());
        			bundle.putString("insurance",insuranceEditText.getText().toString());
        			bundle.putString("zipCode",zipEditText.getText().toString());
        			bundle.putString("monthChoice",monthChoice);
        			bundle.putString("yearChoice",yearChoice);
        			
        			intent.putExtras(bundle);
        			startActivity(intent);     
        	     
        	}
        });
        
	}
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        /* Use the following switch-statement if you want to keep all spinner actions/callbacks together */
        /* The same can be done to the onNothingSelected callback */
        switch(parent.getId()) {
        case R.id.monthSpinner:
            // Do stuff for spinner1
            //showToast("monthSpinner: position=" + position + ", Value= " + parent.getItemAtPosition(position));
            monthChoice = (String) parent.getItemAtPosition(position);
            break;
         case R.id.yearSpinner:
        //     // Do stuff for spinner2
            // showToast("monthSpinner: position=" + position +", Value= " + parent.getItemAtPosition(position));
             yearChoice = (String)parent.getItemAtPosition(position);
            break;
        }
    }
 
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "You selected nothing", Toast.LENGTH_LONG).show();
    }


//    public void showToast(CharSequence msg) {
//    	Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//    }	
//			
		
		
	private void findAllViewsId(){
		priceEditText = (EditText) findViewById(R.id.purchasePriceEditText);
			
		monthSpinner = (Spinner)findViewById(R.id.monthSpinner);
		yearSpinner = (Spinner)findViewById(R.id.yearSpinner);
		
		
		downPayEditText = (EditText) findViewById(R.id.downPaymentEditText);
		termEditText = (EditText) findViewById(R.id.termEditText);
		interestRateEditText = (EditText) findViewById(R.id.interestRateEditText);
		taxEditText = (EditText) findViewById(R.id.taxEditText);
		insuranceEditText = (EditText) findViewById(R.id.insuranceEditText);
		zipEditText = (EditText)findViewById(R.id.zipEditText);
		button = (Button)findViewById(R.id.btnCalculate);
			
			
			
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
