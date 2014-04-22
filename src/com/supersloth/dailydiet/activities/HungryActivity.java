package com.supersloth.dailydiet.activities;
 
import java.util.Random;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
 
import com.supersloth.dailydiet.R;
 
public class HungryActivity extends Activity{
 
    int size = 4;
    int num;
    Random rand = new Random();
    TextView snackName;
    TextView snackDescription;
    String[] nameArray = new String[size];
    String[] descriptionArray = new String[size];
    ImageView image;
    Button nextSnack;
     
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_hungry);
         
        snackName = (TextView)findViewById(R.id.tvSnackName);
        snackDescription = (TextView)findViewById(R.id.tvSnackInfo);
        image = (ImageView)findViewById(R.id.imgTastyPic);
         
        nextSnack = (Button)findViewById(R.id.bNextSnack);
 
        nameArray[0] = "Carrots";
        nameArray[1] = "Granola Bar";
        nameArray[2] = "Grapes";
        nameArray[3] = "Yogurt";
         
        descriptionArray[0] = "Grab a handful of carrots. They contain a "
                + "large number of vitamins and minerals that boost immune "
                + "system and even strengthens your bones.";
        descriptionArray[1] = "Granola is high in fiber which helps lower your "
                + "cholesterol and can aid in the fight against heart disease. "
                + "But don't just grab any granola bar. Look at what it contains "
                + "as most store bought granola bars are full of sugar and preservatives "
                + "that are extrememly unhelathy for you.";
        descriptionArray[2] = "Grapes are a great source of vitamins and a cup full of grapes "
                + "can account for upto a quarter of your daily recommended value of Vitamins "
                + "A and C. Some grape seeds edible and are packed full of antioxidants which are "
                + "important for carrying impurities out of your body.";
        descriptionArray[3] = "If you have an allergy to dairy products, this is not a snack for you. "
                + "Yogurt has an abundant amount of vitamins and minerals. It also contains a "
                + "healthy amoount of protein which is necessary for your body to repair itself. "
                + "It is also good for boosting your immune system, lowering your cholesterol "
                + "and helps your body break down food so your body can digest it much easier.";
         
        num = rand.nextInt(4);
         
        snackName.setText(nameArray[num].toString());
        snackDescription.setText(descriptionArray[num].toString());
         
        switch (num) {
        case 0: image.setImageResource(R.drawable.carrots);
            break;
        case 1: image.setImageResource(R.drawable.granolabar);
            break;
        case 2: image.setImageResource(R.drawable.grapes);
            break;
        case 3: image.setImageResource(R.drawable.yogurt);
            break;
        default: image.setImageResource(R.drawable.yogurt);
                 snackName.setText(nameArray[3].toString());
                 snackDescription.setText(descriptionArray[3].toString());
        }
         
        nextSnack.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                num = rand.nextInt(4);
                snackName.setText(nameArray[num].toString());
                snackDescription.setText(descriptionArray[num].toString());
                 
                switch (num) {
                case 0: image.setImageResource(R.drawable.carrots);
                    break;
                case 1: image.setImageResource(R.drawable.granolabar);
                    break;
                case 2: image.setImageResource(R.drawable.grapes);
                    break;
                case 3: image.setImageResource(R.drawable.yogurt);
                    break;
                default: image.setImageResource(R.drawable.yogurt);
                         snackName.setText(nameArray[3].toString());
                         snackDescription.setText(descriptionArray[3].toString());
                }
                 
            }
        });
    }
}