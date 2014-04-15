package com.supersloth.dailydiet.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.supersloth.dailydiet.R;

public class SplashScreen extends Activity{

	private static int SPLASH_TIME_OUT = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		new Handler().postDelayed(new Runnable(){

			// displays super sloth splash screen
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SplashScreen.this, MainActivity.class);
				startActivity(intent);
				
				finish();
			}
			
		}, SPLASH_TIME_OUT);
	}

	
	
}
