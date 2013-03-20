package edu.psu.ktwok.pocketplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class GameSelect extends Activity{
	Intent i;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game_select);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
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
