package edu.psu.ktwok.pocketplayer;

import java.util.regex.Pattern;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	Intent i;
	private static final int SETTINGS_ACTIVITY_REQUEST_CODE = 200;
	public final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
			"^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
	         +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	         +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
	         +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
	         +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
	         +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$");
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final EditText txtUser = (EditText) findViewById(R.id.reg_fullname);
		final EditText txtEmail = (EditText) findViewById(R.id.reg_email);
		final EditText txtPassword = (EditText) findViewById(R.id.reg_password);

		// Enable ActionBar
		ActionBar abar = getActionBar();
		abar.setDisplayHomeAsUpEnabled(true);
		
		// Link to Login Screen
		TextView loginScreen = (TextView) findViewById(R.id.link_to_login);
		loginScreen.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				txtUser.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
				finish();				
			}
		});
		
		// Button to Register
		Button btn = (Button) findViewById(R.id.btnRegister);
		btn.setOnClickListener(new OnClickListener() {					
		
			@Override
			public void onClick(View v) {
				String user = txtUser.getText().toString();
				String email = txtEmail.getText().toString();
				if (!isValidEmail(email)) {
					Toast.makeText(RegisterActivity.this, "EMAIL NOT VALID", Toast.LENGTH_SHORT).show();
					txtEmail.requestFocus();
				}
				else {
					String password = txtPassword.getText().toString();
				
					try {
						if (user.length() > 0 && email.length() > 0 && password.length() > 0) {
							UsersDataSource uds = new UsersDataSource(RegisterActivity.this);
							uds.open();
							uds.register(user, email, password);
							Toast.makeText(RegisterActivity.this, "REGISTRATION SUCCESSFULL", Toast.LENGTH_SHORT).show();
							i = new Intent(getApplicationContext(),LoginActivity.class);
							startActivity(i);
							uds.close();
						}
					}
					catch (Exception e) {
						Toast.makeText(RegisterActivity.this, "SOMETHING WENT WRONG!", Toast.LENGTH_SHORT).show();
					}
				}
				txtEmail.setText("");
				txtPassword.setText("");
			}

			private boolean isValidEmail(String email) {
				return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
			case android.R.id.home:
				i = new Intent(this, TitleScreen.class);
				i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
				return true;
			case R.id.tab1:
				AboutDialogFrag newFrag = new AboutDialogFrag();
				newFrag.show(getFragmentManager(), "sdfTest");
				return true;
			case R.id.menu_settings:
				i = new Intent(this, SettingsActivity.class);
				startActivityForResult(i, SETTINGS_ACTIVITY_REQUEST_CODE);
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
}