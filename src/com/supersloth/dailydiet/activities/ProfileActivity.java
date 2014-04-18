package com.supersloth.dailydiet.activities; 
  
import android.app.Activity; 
import android.content.Intent;
import android.content.SharedPreferences; 
import android.content.SharedPreferences.Editor; 
import android.os.Bundle; 
import android.preference.PreferenceManager; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast;
  
import com.supersloth.dailydiet.R; 
  
public class ProfileActivity extends Activity implements OnClickListener { 
  
    EditText etName; 
    EditText etAge; 
    EditText etHeight; 
    EditText etWeight; 
    EditText etGoal; 
    EditText etProgress; 
      
    Button bSave; 
      
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        // TODO Auto-generated method stub 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_profile); 
          
        etName = (EditText) findViewById(R.id.etUserName); 
        etAge = (EditText) findViewById(R.id.etUserAge); 
        etHeight = (EditText) findViewById(R.id.etUserHeight); 
        etWeight = (EditText) findViewById(R.id.etUserWeight); 
        etGoal = (EditText) findViewById(R.id.etUserGoal); 
        etProgress = (EditText) findViewById(R.id.etUserProgress); 
          
        bSave = (Button) findViewById(R.id.bSaveProfile); 
        bSave.setOnClickListener(this); 
          
        loadData(); 
          
    } 
    
  
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		loadData();
	}


	private void loadData() { 
        // TODO Auto-generated method stub 
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this); 
          
        String userName = sharedPreferences.getString("userName", null); 
          
        etName.setText(userName); 
        Toast toast = Toast.makeText(getApplicationContext(), "user name: " + userName, Toast.LENGTH_SHORT);
        toast.show();
    } 
 
      
    @Override
    public void onClick(View v) { 
//        saveData("UserName", etName.getText().toString(), 
//                 "UserAge", Integer.parseInt(etAge.getText().toString()), 
//                 "UserHeight", Integer.parseInt(etHeight.getText().toString()), 
//                 "UserWeight", Integer.parseInt(etWeight.getText().toString()), 
//                 "UserGoal", Integer.parseInt(etGoal.getText().toString()), 
//                 "UserProgress", Integer.parseInt(etProgress.getText().toString())); 
          if(v.getId() == R.id.bSaveProfile){
        	  Intent intent = new Intent(this, EditProfileActivity.class);
        	  startActivity(intent);
          }
          
    } 
      
} 