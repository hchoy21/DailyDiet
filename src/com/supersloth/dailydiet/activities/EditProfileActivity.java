package com.supersloth.dailydiet.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.supersloth.dailydiet.R;

public class EditProfileActivity extends Activity {
    
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       // TODO Auto-generated method stub
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_edit_profile);
        
       // separate class to assign all variables
       setupVariables();
        
   }
    
   private void setupVariables() {
        
       Button updateProfile = (Button) findViewById(R.id.bUpdateProfile);
       final EditText etProfileName = (EditText) findViewById(R.id.etName);
       final EditText etUserAge = (EditText) findViewById(R.id.etAge);
       final EditText etUserHeight = (EditText) findViewById(R.id.etHeight);
       final EditText etBeginWeight = (EditText) findViewById(R.id.etStartWeight);
       final EditText etEndWeight = (EditText) findViewById(R.id.etGoalWeight);
//       final EditText etUserWeight = (EditText) findViewById(R.id.etProgressWeight);
        
       // set all the EditTexts to a String Variable
       String userName = etProfileName.getText().toString();
       int userAge = Integer.parseInt(etUserAge.getText().toString());
       int userHeight = Integer.parseInt(etUserHeight.getText().toString());
       int userWeight = Integer.parseInt(etBeginWeight.getText().toString());
       int userGoal = Integer.parseInt(etEndWeight.getText().toString());
//       int userProgress = Integer.parseInt(etUserWeight.getText().toString());
        
       // button action
       updateProfile.setOnClickListener(new OnClickListener() {
            
               @Override
               public void onClick(View v) {   

                   updateProfileButton();
               }
       });
   }
        
   // Connect Buttons to action
   public void updateProfileButton() {
       Intent intent = new Intent(this, ProfileActivity.class);
       startActivity(intent);
   }
}