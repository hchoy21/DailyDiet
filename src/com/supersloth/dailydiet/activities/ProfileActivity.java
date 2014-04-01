package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class ProfileActivity extends Activity{
	
	Button btnUpdate;
	Button btnProgressPic;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		
	
		btnUpdate = (Button) findViewById(R.id.bUpdateProfile);	
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
		
		
		btnProgressPic = (Button) findViewById(R.id.bProgressPicture);
		btnProgressPic.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startImageActivity();
			}
		});
	}
	
	
	private void startImageActivity(){
		Intent intent = new Intent(this, PictureActivity.class);
		startActivity(intent);
	}
	
	
	
}
