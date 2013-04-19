package edu.psu.ktwok.pocketplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	Intent i;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final EditText txtUser = (EditText) findViewById(R.id.reg_fullname);
		final EditText txtEmail = (EditText) findViewById(R.id.reg_email);
		final EditText txtPassword = (EditText) findViewById(R.id.reg_password);
		
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
				txtUser.setText("");
				txtEmail.setText("");
				txtPassword.setText("");
			}
		});
	}
}
