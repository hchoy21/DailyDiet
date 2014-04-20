package com.supersloth.dailydiet.activities; 
  
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.supersloth.dailydiet.R;
  
public class ProfileActivity extends Activity  { 
      
    public static final String PREFS_NAME = "MyPreferencesFile"; 
      
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_profile); 
        
        // initialize textviews and button
        TextView tvName = (TextView)findViewById(R.id.tvName); 
        TextView tvAge = (TextView)findViewById(R.id.tvAge); 
        TextView tvHeight = (TextView)findViewById(R.id.tvHeight); 
        TextView tvWeight = (TextView)findViewById(R.id.tvWeight); 
        TextView tvGoal = (TextView)findViewById(R.id.tvGoal); 
        TextView tvProgress = (TextView)findViewById(R.id.tvProgress); 
        
        Button editProfile = (Button)findViewById(R.id.bEditProfile); 
        
        // call SharedPrefernces and filename
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); 
        
        // assign textviews the values received from editProfile
        tvName.setText(settings.getString("name", "Super Sloth")); 
        tvAge.setText(String.valueOf(settings.getInt("age", 21))); 
        tvHeight.setText(String.valueOf(settings.getInt("height", 68))); 
        tvWeight.setText(String.valueOf(settings.getInt("weight", 175))); 
        tvGoal.setText(String.valueOf(settings.getInt("goal", 150))); 
        tvProgress.setText(String.valueOf(settings.getInt("progress", 160))); 
        
        // when button is clicked
        editProfile.setOnClickListener(new View.OnClickListener() { 
              
            @Override
            public void onClick(View v) { 
                editProfileButton();
            } 
        });      
    }
    
    private void editProfileButton(){
    	Intent intent = new Intent(this, EditProfileActivity.class);
    	startActivity(intent);
    }
} 