package edu.psu.ktwok.pocketplayer;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SplashScreen extends Activity {
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
			.setMessage("Are you sure you want to exit?")
//			.setCancelable(false)
			.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
					Toast toast = Toast.makeText(getApplicationContext(), "Thank You For Using Pocket Player!", Toast.LENGTH_SHORT);
					toast.show();
					SplashScreen.this.finish();
				}
			})
			.setNegativeButton("Cancel", null)
			.show();
	}
	
	public void goToTitle(View v) {
		intent = new Intent(this, TitleScreen.class);
		startActivity(intent);
		finish();
	}
}
