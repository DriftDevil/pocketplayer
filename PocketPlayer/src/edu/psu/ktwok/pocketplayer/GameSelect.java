package edu.psu.ktwok.pocketplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GameSelect extends Activity{
	Intent i;
	private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_select);
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
			case R.id.menu_settings:
				i = new Intent(this, SettingsActivity.class);
				startActivityForResult(i, SETTINGS_ACTIVITY_REQUEST_CODE);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
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
