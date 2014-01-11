/*
 * Right now this is the child of GenderMenu. Should probably be the child of the measurement menus. Maybe not
 */


package com.kelly.findmysize;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;

public class StoreMenu extends Activity {

	public int gender = -1;
	public String store = "";
	final static String EXTRA_STORE = "com.kelly.findmysize.STORE";
	final static String TAG = "com.kelly.findmysize.DEBUG_TAG";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_store_menu);
		// Show the Up button in the action bar.
		setupActionBar();
		
		gender = getIntent().getIntExtra(GenderMenu.EXTRA_GENDER, -1);
		Log.d(TAG, "" + gender);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			setTitle(R.string.app_name);
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.store_menu, menu);
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
	
	public void findSize() {
		
		Intent intent = new Intent(this, SizeCalculator.class);
		intent.putExtra(EXTRA_STORE, store);
		intent.putExtra(GenderMenu.EXTRA_GENDER, gender);
		
		switch (gender) {
			case 0: { //Female
				intent.putExtra(FemaleMeasurements.EXTRA_BUST, getIntent().getDoubleExtra(FemaleMeasurements.EXTRA_BUST, -1));
				intent.putExtra(FemaleMeasurements.EXTRA_HIP, getIntent().getDoubleExtra(FemaleMeasurements.EXTRA_HIP, -1));
				intent.putExtra(FemaleMeasurements.EXTRA_WAIST, getIntent().getDoubleExtra(FemaleMeasurements.EXTRA_WAIST, -1));
				intent.putExtra(FemaleMeasurements.EXTRA_INSEAM, getIntent().getDoubleExtra(FemaleMeasurements.EXTRA_INSEAM, -1));
				break;
			}
			case 1: { //Male
				intent.putExtra(MaleMeasurements.EXTRA_CHEST, getIntent().getDoubleExtra(MaleMeasurements.EXTRA_CHEST, -1));
				intent.putExtra(MaleMeasurements.EXTRA_SLEEVE, getIntent().getDoubleExtra(MaleMeasurements.EXTRA_SLEEVE, -1));
				intent.putExtra(MaleMeasurements.EXTRA_WAIST, getIntent().getDoubleExtra(MaleMeasurements.EXTRA_WAIST, -1));
				break;
			}
			case 2: { //Child
				intent.putExtra(ChildMeasurements.EXTRA_HEIGHT, getIntent().getDoubleExtra(ChildMeasurements.EXTRA_HEIGHT, -1));
				intent.putExtra(ChildMeasurements.EXTRA_WEIGHT, getIntent().getDoubleExtra(ChildMeasurements.EXTRA_WEIGHT, -1));
				intent.putExtra(ChildMeasurements.EXTRA_CHEST, getIntent().getDoubleExtra(ChildMeasurements.EXTRA_CHEST, -1));
				intent.putExtra(ChildMeasurements.EXTRA_WAIST, getIntent().getDoubleExtra(ChildMeasurements.EXTRA_WAIST, -1));
				break;
			}
			}
		startActivity(intent);
	}
	
	public void setAeropostale(View view) {
		store = "Aero";
		findSize();
	}
	
	public void setAbercrombie(View view) {
		store = "Abercrombie";
		findSize();
	}
	
	public void setAA(View view) {
		store = "AA";
		findSize();
	}
	
	public void setAE(View view) {
		store = "AE";
		findSize();
	}
	
	public void setDelias(View view) {
		store = "Delias";
		findSize();
	}
	
	public void setF21(View view) {
		store = "F21";
		findSize();
	}
	
	public void setGap(View view) {
		store = "Gap";
		findSize();
	}
	
	public void setGK(View view) {
		store = "GK";
		findSize();
	}
	
	public void setHM(View view) {
		store = "HM";
		findSize();
	}
	
	public void setJustice(View view) {
		store = "Justice";
		findSize();
	}
	
	public void setTillys(View view) {
		store = "Tillys";
		findSize();
	}
	
	public void setUO(View view) {
		store = "UO";
		findSize();
	}
	
	public void setVans(View view) {
		store = "Vans";
		findSize();
	}

}
