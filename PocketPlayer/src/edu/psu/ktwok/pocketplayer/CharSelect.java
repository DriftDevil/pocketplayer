package edu.psu.ktwok.pocketplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CharSelect extends Activity{
	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_char_select);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_character_select, menu);	
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.char_info:
			i = new Intent(this, ContactMail.class);
			startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
	public void goToCharInfo(View v) {
		i = new Intent(this, CharInfo.class);
		startActivity(i);
	}
}
