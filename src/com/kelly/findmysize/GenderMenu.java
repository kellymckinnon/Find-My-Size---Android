package com.kelly.findmysize;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;

public class GenderMenu extends Activity {

	final static String EXTRA_GENDER = "com.kelly.findmysize.GENDER";
	private int gender=-1; //0=F; 1=M; 2=C
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gender_menu);
		setTitle(R.string.app_name);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gender_menu, menu);
		return true;
	}
	
	public void setFemale(View view) {
		gender = 0;
		Intent intent = new Intent(this, FemaleMeasurements.class);
		intent.putExtra(EXTRA_GENDER, gender);
		startActivity(intent);
	}
	
	public void setMale(View view) {
		gender = 1;
		Intent intent = new Intent(this, MaleMeasurements.class);
		intent.putExtra(EXTRA_GENDER, gender);
		startActivity(intent);
	}
	
	public void setChild(View view) {
		gender = 2;
		Intent intent = new Intent(this, ChildMeasurements.class);
		intent.putExtra(EXTRA_GENDER, gender);
		startActivity(intent);
	}
	
}
