package com.supersloth.dailydiet.activities;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class GroceryListActivity extends Activity{
	private CheckBox chicken, beef, pork, fish, turkey,
			mushroom, lettuce, broccoli, tomato, bean, 
			rice, pasta, bread, tortilla, potato;
	private Button update;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocerylist);
		
		
		chicken = (CheckBox) findViewById(R.id.cbChicken);
		beef = (CheckBox) findViewById(R.id.cbBeef);
		pork = (CheckBox) findViewById(R.id.cbPork);
		fish = (CheckBox) findViewById(R.id.cbFish);
		turkey = (CheckBox) findViewById(R.id.cbTurkey);
		mushroom = (CheckBox) findViewById(R.id.cbMushrooms);
		lettuce = (CheckBox) findViewById(R.id.cbLettuce);
		broccoli = (CheckBox) findViewById(R.id.cbBroccoli);
		tomato = (CheckBox) findViewById(R.id.cbTomato);
		bean = (CheckBox) findViewById(R.id.cbBeans);
		rice = (CheckBox) findViewById(R.id.cbRice);
		pasta = (CheckBox) findViewById(R.id.cbPasta);
		bread = (CheckBox) findViewById(R.id.cbBread);
		tortilla = (CheckBox) findViewById(R.id.cbTortilla);
		potato = (CheckBox) findViewById(R.id.cbPotato);
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		chicken.setChecked(sp.getBoolean("chicken", false));
	 	beef.setChecked(sp.getBoolean("beef", false));
	 	pork.setChecked(sp.getBoolean("pork", false));
	 	fish.setChecked(sp.getBoolean("fish", false));
	 	turkey.setChecked(sp.getBoolean("turkey", false));
	 	mushroom.setChecked(sp.getBoolean("mushroom", false));
	 	lettuce.setChecked(sp.getBoolean("lettuce", false));
	 	broccoli.setChecked(sp.getBoolean("broccoli", false));
	 	tomato.setChecked(sp.getBoolean("tomato", false));
	 	bean.setChecked(sp.getBoolean("bean", false));
	 	rice.setChecked(sp.getBoolean("rice", false));
	 	pasta.setChecked(sp.getBoolean("pasta", false));
	 	bread.setChecked(sp.getBoolean("bread", false));
	 	tortilla.setChecked(sp.getBoolean("tortilla", false));
	 	potato.setChecked(sp.getBoolean("potato", false));


		update = (Button) findViewById(R.id.bUpdateGroceryList);
		update.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){

				Log.d("Test", "Update button clicked");
				Toast toast = Toast.makeText(getApplicationContext(), "Grocery List Updated!", Toast.LENGTH_SHORT);
				toast.show();
				savePref();
			}
		});
		
	}
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		chicken.setChecked(sp.getBoolean("chicken", false));
	 	beef.setChecked(sp.getBoolean("beef", false));
	 	pork.setChecked(sp.getBoolean("pork", false));
	 	fish.setChecked(sp.getBoolean("fish", false));
	 	turkey.setChecked(sp.getBoolean("turkey", false));
	 	mushroom.setChecked(sp.getBoolean("mushroom", false));
	 	lettuce.setChecked(sp.getBoolean("lettuce", false));
	 	broccoli.setChecked(sp.getBoolean("broccoli", false));
	 	tomato.setChecked(sp.getBoolean("tomato", false));
	 	bean.setChecked(sp.getBoolean("beans", false));
	 	rice.setChecked(sp.getBoolean("rice", false));
	 	pasta.setChecked(sp.getBoolean("pasta", false));
	 	bread.setChecked(sp.getBoolean("bread", false));
	 	tortilla.setChecked(sp.getBoolean("tortilla", false));
	 	potato.setChecked(sp.getBoolean("potato", false));
	}



	public void onCheckBoxClicked(View v){
		
		boolean checked = ((CheckBox)v).isChecked();
		
		switch(v.getId()){
			case R.id.cbChicken: 
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "chicken clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbBeef:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "beef clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbPork:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "pork clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbFish:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "fish clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbTurkey:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "turkey clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbMushrooms:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "mushroom clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbLettuce:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "lettuce clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbBroccoli:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "broccoli clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbTomato:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "tomato clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
			case R.id.cbBeans:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "beans clicked", Toast.LENGTH_SHORT);
					toast.show();
				}
				break;
		}
		
	}

	public void savePref(){

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		
		editor.putBoolean("chicken", chicken.isChecked());
		editor.putBoolean("beef", beef.isChecked());
		editor.putBoolean("pork", pork.isChecked());
		editor.putBoolean("fish", fish.isChecked());
		editor.putBoolean("turkey", turkey.isChecked());
		editor.putBoolean("mushrooms", mushroom.isChecked());
		editor.putBoolean("lettuce", lettuce.isChecked());
		editor.putBoolean("broccoli", broccoli.isChecked());
		editor.putBoolean("tomato", tomato.isChecked());
		editor.putBoolean("beans", bean.isChecked());
		editor.putBoolean("rice", rice.isChecked());
		editor.putBoolean("pasta", pasta.isChecked());
		editor.putBoolean("bread", bread.isChecked());
		editor.putBoolean("tortilla", tortilla.isChecked());
		editor.putBoolean("potato", potato.isChecked());
		
		
		

		editor.commit();

	}
}