package com.supersloth.dailydiet.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.supersloth.dailydiet.R;
import com.supersloth.dailydiet.profile.SaveProfile;
 
public class ProgressActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        setupVariables();
         
    }
     
    public void setupVariables() {
         
        Button updateWeight = (Button) findViewById(R.id.bUpdateWeight);
        final EditText etProfileName = (EditText) findViewById(R.id.etName);
        final EditText etUserAge = (EditText) findViewById(R.id.etAge);
        final EditText etUserHeight = (EditText) findViewById(R.id.etHeight);
        final EditText etBeginWeight = (EditText) findViewById(R.id.etStartWeight);
        final EditText etEndWeight = (EditText) findViewById(R.id.etGoalWeight);
        final EditText etUserWeight = (EditText) findViewById(R.id.etProgressWeight);
         
        // set all the EditTexts to a String Variable
        String userName = etProfileName.getText().toString();
        int userAge = Integer.parseInt(etUserAge.getText().toString());
        int userHeight = Integer.parseInt(etUserHeight.getText().toString());
        double userWeight = Double.parseDouble(etBeginWeight.getText().toString());
        double userGoal = Double.parseDouble(etEndWeight.getText().toString());
        double userProgress = Double.parseDouble(etUserWeight.getText().toString());
         
        SaveProfile saveProfile = new SaveProfile(userName, userAge, userHeight, userWeight, userGoal, userProgress);
 
//      Intent intent = new Intent(this, MainActivity.class);
         
        updateWeight.setOnClickListener(new OnClickListener() {
             
            @Override
            public void onClick(View v) {
                 
                updateWeightButton();
            }
        });
    }
     
    // Connect Buttons to action
    public void updateWeightButton() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
 
}