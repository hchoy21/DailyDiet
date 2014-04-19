package com.supersloth.dailydiet.activities; 
  
import android.app.Activity; 
import android.os.Bundle; 
import android.util.Log;
import android.view.View; 
import android.widget.Button; 
import android.widget.TextView; 
  
import com.supersloth.dailydiet.R; 
  
public class HealthyTipsActivity extends Activity{ 
      
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_healthy_tips); 
          
        // initialize TextViews and Button 
        final TextView tip = (TextView)findViewById(R.id.tvTip); 
        final TextView advice = (TextView)findViewById(R.id.tvTipNum); 
          
        Button next = (Button)findViewById(R.id.bNext); 
          
        final int size = 5; 
          
        // initialize Arrays 
        final String[] tipArray = new String[size]; 
        final String[] adviceArray = new String[size]; 
          
        // fill arrays  
        tipArray[0] = "Drink Plenty of Water"; 
        tipArray[1] = "Get Plenty of Sleep"; 
        tipArray[2] = "Stick With It"; 
        tipArray[3] = "Eat 7 Small Meals"; 
        tipArray[4] = "Alcohol"; 
          
        adviceArray[0] = "The average person should consume at least 64 ounces of water perday. "
                + "Avoid consuming anything with sugar."
                + "When dieting and exercising the average person should consume upto "
                + "100 ounces of water each day."; 
        adviceArray[1] = "You should stick with a daily routine."
                + "Go to sleep at the same time everyday and wake up at the same time everyday."
                + "Try to get 8 hours of sleep a night and avoid taking naps during the day as this "
                + "will slow down your metabalism."; 
        adviceArray[2] = "You will not see results right away."
                + "It is important to remember that dieting takes time and patience."
                + "Most results will happen slowly so you wont even notice the changes."
                + "This is why it is important to only weigh yourself once a week at most."; 
        adviceArray[3] = "Try eating 7 small meals per day rather than 3 major meals."
                + "This keeps your metabalism going so your body continuosly burns unwanted calories."; 
        adviceArray[4] = "You should avoid alcohol while trying to lose weight as alcohol contains hundreds "
                + "of unwanted calories. Although it is ok to have ONE dark beer after a workout"
                + "as this contains nutrients your body needs to recover."; 
          
        // Set TextViews to show a value at onCreate 
        tip.setText(tipArray[0].toString()); 
        advice.setText(adviceArray[0].toString()); 
          
        
        
        // When button is clicked change both TextViews 
        next.setOnClickListener(new View.OnClickListener() { 
        	int tipCounter = 0;
            @Override
            public void onClick(View v) { 
                
            	Log.d("Healthy Tips Activity", "next button clicked");
                // for loop to step through array 
                while(tipCounter < 5) { 
                     
                    // if i is equal to 4 then restart it back at 0 
//                    if (i == 5) { 
//                        i = 0; 
//                    } 
                      
                    // set TextViews to value in the array 
                    tip.setText(tipArray[tipCounter].toString()); 
                    advice.setText(adviceArray[tipCounter].toString()); 
                    tipCounter++;
                
                }
            } 
        }); 
    } 
} 