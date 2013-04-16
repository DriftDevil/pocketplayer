package edu.psu.ktwok.pocketplayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TitleScreen extends Activity {

	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title_screen);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.title_screen, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case R.id.tab1:
				AboutDialogFrag newFrag = new AboutDialogFrag();
				newFrag.show(getFragmentManager(), "sdfTest");
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onBackPressed() {
		intent = new Intent(this, SplashScreen.class);
		startActivity(intent);
	}
	
	public void goToLogin(View v) {
		intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
	}
	
	public void exitApp(View v) {
		finish();
		System.exit(0);
	}

}
