package com.supersloth.dailydiet.activities; 
  
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
          
        TextView tvName = (TextView)findViewById(R.id.tvName); 
        TextView tvAge = (TextView)findViewById(R.id.tvAge); 
        TextView tvHeight = (TextView)findViewById(R.id.tvHeight); 
        TextView tvWeight = (TextView)findViewById(R.id.tvWeight); 
        TextView tvGoal = (TextView)findViewById(R.id.tvGoal); 
        TextView tvProgress = (TextView)findViewById(R.id.tvProgress); 
          
        Button editProfile = (Button)findViewById(R.id.bEditProfile); 
          
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); 
        
//        String name = settings.getString("name", "Please").toString();
        
//        Log.d("Profile", settings.getString("name", "Please"));
//        Log.d("Profile", settings.getInt("age", 18));
//        Log.d("Profile", settings.getInt("height", 68));
//        Log.d("Profile", settings.getInt("weight", 175));
//        Log.d("Profile", settings.getInt("goal", 150));
//        Log.d("Profile", settings.getInt("progress", 160));
        
        
        tvName.setText(settings.getString("name", "Please")); 
        tvAge.setText(String.valueOf(settings.getInt("age", 18))); 
        tvHeight.setText(String.valueOf(settings.getInt("height", 68))); 
        tvWeight.setText(String.valueOf(settings.getInt("weight", 175))); 
        tvGoal.setText(String.valueOf(settings.getInt("goal", 150))); 
        tvProgress.setText(String.valueOf(settings.getInt("progress", 160))); 
          
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