package edu.psu.ktwok.pocketplayer;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
		// Enable Action Bar
		ActionBar aBar = getActionBar();
		aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
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
			case R.id.btnAbout:
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
	
	public void goToAbout(View v) {
//		intent = new Intent(this, AppInfo.class);
//		startActivity(intent);
		AboutDialogFrag adf = new AboutDialogFrag();
		adf.show(getFragmentManager(), "dialog");
	}
	
	public void exitApp(View v) {
		finish();
		System.exit(0);
	}

}
