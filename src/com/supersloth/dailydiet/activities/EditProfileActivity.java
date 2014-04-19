package com.supersloth.dailydiet.activities; 
  
  
import android.app.Activity; 
import android.content.Intent; 
import android.content.SharedPreferences; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast; 
  
import com.supersloth.dailydiet.R; 
  
public class EditProfileActivity extends Activity { 
      
    public static final String PREFS_NAME = "MyPreferencesFile"; 
      
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_edit_profile); 
          
        final EditText name = (EditText)findViewById(R.id.etName); 
        final EditText age = (EditText)findViewById(R.id.etAge); 
        final EditText height = (EditText)findViewById(R.id.etHeight); 
        final EditText weight = (EditText)findViewById(R.id.etWeight); 
        final EditText goal = (EditText)findViewById(R.id.etGoal); 
        final EditText progress = (EditText)findViewById(R.id.etProgress); 
        Button save = (Button)findViewById(R.id.bSaveProfile); 
          
        save.setOnClickListener(new View.OnClickListener() { 
              
            @Override
            public void onClick(View v) { 
                  
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0); 
                SharedPreferences.Editor editor = settings.edit(); 
                editor.putString("name", name.getText().toString()); 
                editor.putInt("age", Integer.parseInt(age.getText().toString())); 
                editor.putInt("height", Integer.parseInt(height.getText().toString())); 
                editor.putInt("weight", Integer.parseInt(weight.getText().toString())); 
                editor.putInt("goal", Integer.parseInt(goal.getText().toString())); 
                editor.putInt("progress", Integer.parseInt(progress.getText().toString())); 
                  
                editor.commit(); 
                  
                String msg = "Profile Saved!"; 
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show(); 
                  
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class); 
                startActivity(intent); 
                  
            } 
        }); 
          
   } 
    
}