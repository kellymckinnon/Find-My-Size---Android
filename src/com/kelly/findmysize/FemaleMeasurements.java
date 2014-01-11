package com.kelly.findmysize;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class FemaleMeasurements extends Activity {

	int gender;
	final static String EXTRA_BUST = "com.kelly.findmysize.BUST";
	final static String EXTRA_HIP = "com.kelly.findmysize.HIP";
	final static String EXTRA_WAIST = "com.kelly.findmysize.WAIST";
	final static String EXTRA_INSEAM = "com.kelly.findmysize.INSEAM";
	private final static int EMPTY_TEXT = -42;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_female_measurements);
		// Show the Up button in the action bar.
		setupActionBar();
		
		gender = getIntent().getIntExtra(GenderMenu.EXTRA_GENDER, -1);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.female_measurements, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public Dialog onCreateDialog(int id) {
		switch(id) {
			case EMPTY_TEXT: {
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("Please enter at least one measurement.").setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
			return builder.create();
			}
		}
		
		return null;
	}
	
	public void goToStores(View view) {
    	String bust_ = ((EditText) findViewById(R.id.editTextBust)).getText().toString().trim();
    	String hip_ =  ((EditText) findViewById(R.id.editTextHip)).getText().toString().trim();
    	String waist_ =  ((EditText) findViewById(R.id.editTextWaist)).getText().toString().trim();
    	String inseam_ =  ((EditText) findViewById(R.id.editTextInseam)).getText().toString().trim();
		double bust = -1, hip = -1, waist = -1, inseam = -1;
    	
		int numEmpty = 0; //Number of empty fields
		
		/*
		 * Inputs have to be checked for emptiness, else parsing will throw error.
		 */
		if(bust_.isEmpty()) numEmpty++; else bust = Double.parseDouble(bust_);
		if(hip_.isEmpty()) numEmpty++; else hip = Double.parseDouble(hip_);
		if(waist_.isEmpty()) numEmpty++; else waist = Double.parseDouble(waist_);
		if(inseam_.isEmpty()) numEmpty++; else inseam = Double.parseDouble(inseam_);
				
		if(numEmpty==4) { //All empty
			showDialog(EMPTY_TEXT);
			return;
		}
    	
		
		Intent intent = new Intent(this, StoreMenu.class);
		intent.putExtra(GenderMenu.EXTRA_GENDER, gender);
		intent.putExtra(EXTRA_BUST, bust);
		intent.putExtra(EXTRA_HIP, hip);
		intent.putExtra(EXTRA_WAIST, waist);
		intent.putExtra(EXTRA_INSEAM, inseam);
		startActivity(intent);
	}
	
	

}
