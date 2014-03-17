package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class ProfileActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
		Button btnUpdate = (Button) findViewById(R.id.bUpdateProfile);
		
		btnUpdate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context context = getApplicationContext();	
				CharSequence message = "Profile updated";
				int duration = Toast.LENGTH_SHORT;
				Toast profileUpdateNotification = Toast.makeText(context, message, duration);
				profileUpdateNotification.show();
			}
		});
	}
	
	
	
}
