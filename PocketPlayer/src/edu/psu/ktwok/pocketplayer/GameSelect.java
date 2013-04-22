package edu.psu.ktwok.pocketplayer;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class GameSelect extends Activity{
	Intent i;
	private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_select);
		
		// Enable ActionBar
		ActionBar abar = getActionBar();
		abar.setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_game_select, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case android.R.id.home:
				i = new Intent(this, LoginActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				new AlertDialog.Builder(this)
				.setMessage("Are you sure you want to logout?")
//				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int id) {
						startActivity(i);
					}
				})
				.setNegativeButton("Cancel", null)
				.show();
				
				return true;
			case R.id.menu_settings:
				i = new Intent(this, SettingsActivity.class);
				startActivityForResult(i, SETTINGS_ACTIVITY_REQUEST_CODE);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public void onBackPressed() {
		i = new Intent(this, LoginActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		new AlertDialog.Builder(this)
			.setMessage("Are you sure you want to logout?")
//			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					startActivity(i);
				}
			})
			.setNegativeButton("Cancel", null)
			.show();
	}
	
	public void goToDD(View v) {
		i = new Intent(this, CharSelect.class);
		startActivity(i);
	}
	
	public void goToPF(View v) {
		i = new Intent(this, CharSelect.class);
		startActivity(i);
	}
	
	
}
