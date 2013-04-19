package edu.psu.ktwok.pocketplayer;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		final EditText txtEmail = (EditText) findViewById(R.id.email);
		final EditText txtPassword = (EditText) findViewById(R.id.password);
		
		// Link to Register Screen
		TextView regScreen = (TextView) findViewById(R.id.link_to_register);
		regScreen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				txtEmail.setText("");
				txtPassword.setText("");
				i = new Intent(getApplicationContext(), RegisterActivity.class);
				startActivity(i);
			}
		});
		
		// Button to Login
		Button btn = (Button) findViewById(R.id.btnLogin);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = txtEmail.getText().toString();
				String password = txtPassword.getText().toString();
				try {
					if (email.length() > 0 && password.length() > 0) {
						UsersDataSource uds = new UsersDataSource(LoginActivity.this);
						uds.open();
				
						if (uds.login(email, password)) {
							Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
							i = new Intent(getApplicationContext(),GameSelect.class);
							startActivity(i);
						}
						else {
							Toast.makeText(LoginActivity.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
						}
						uds.close();
					}
				}
				catch (Exception e) {
					Toast.makeText(LoginActivity.this, "SOMETHING WENT WRONG!", Toast.LENGTH_SHORT).show();
				}
				txtEmail.setText("");
				txtPassword.setText("");
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	public void goToContactList(View v) {
		i = new Intent(this, GameSelect.class);
		startActivity(i);
	}

}
