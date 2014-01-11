package com.kelly.findmysize;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class ChildMeasurements extends Activity {

	int gender;
	final static String EXTRA_CHEST = "com.kelly.findmysize.CHEST";
	final static String EXTRA_HEIGHT = "com.kelly.findmysize.HEIGHT";
	final static String EXTRA_WAIST = "com.kelly.findmysize.WAIST";
	final static String EXTRA_WEIGHT = "com.kelly.findmysize.WEIGHT";
	private final static int EMPTY_TEXT = -42;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_measurements);
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
		getMenuInflater().inflate(R.menu.child_measurements, menu);
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
    	String bustchest_ = ((EditText) findViewById(R.id.editTextBustChest)).getText().toString().trim();
    	String waist_ =  ((EditText) findViewById(R.id.editTextWaist)).getText().toString().trim();
    	String height_ =  ((EditText) findViewById(R.id.editTextHeight)).getText().toString().trim();
    	String weight_ =  ((EditText) findViewById(R.id.editTextWeight)).getText().toString().trim();
		double bustchest = -1, height = -1, waist = -1, weight = -1;
    	
		int numEmpty = 0; //Number of empty fields
		
		/*
		 * Inputs have to be checked for emptiness, else parsing will throw error.
		 */
		if(bustchest_.isEmpty()) numEmpty++; else bustchest = Double.parseDouble(bustchest_);
		if(height_.isEmpty()) numEmpty++; else height = Double.parseDouble(height_);
		if(waist_.isEmpty()) numEmpty++; else waist = Double.parseDouble(waist_);
		if(weight_.isEmpty()) numEmpty++; else weight = Double.parseDouble(weight_);
				
		if(numEmpty==4) { //All empty
			showDialog(EMPTY_TEXT);
			return;
		}
    	
		Intent intent = new Intent(this, StoreMenu.class);
		intent.putExtra(GenderMenu.EXTRA_GENDER, gender);
		intent.putExtra(EXTRA_CHEST, bustchest);
		intent.putExtra(EXTRA_HEIGHT, height);
		intent.putExtra(EXTRA_WAIST, waist);
		intent.putExtra(EXTRA_WEIGHT, weight);
		startActivity(intent);
	}

}
