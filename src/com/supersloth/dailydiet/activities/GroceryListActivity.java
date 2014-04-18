package com.supersloth.dailydiet.activities;

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

import com.supersloth.dailydiet.R;

public class GroceryListActivity extends Activity{
	private CheckBox chicken, beef, pork, fish, lamb, 
			mushrooms, lettuce, broccoli, tomato, beans, 
			rice, pasta, bread, tortilla, potato;
	private Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocerylist);

		update = (Button) findViewById(R.id.bUpdateGroceryList);


		update.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){

				Log.d("Test", "Update button clicked");

				savePref();
			}
		});

		chicken = (CheckBox) findViewById(R.id.cbChicken);
		beef = (CheckBox) findViewById(R.id.cbBeef);
		pork = (CheckBox) findViewById(R.id.cbPork);
		fish = (CheckBox) findViewById(R.id.cbFish);
		lamb = (CheckBox) findViewById(R.id.cbLamb);
		mushrooms = (CheckBox) findViewById(R.id.cbMushrooms);
		lettuce = (CheckBox) findViewById(R.id.cbLettuce);
		broccoli = (CheckBox) findViewById(R.id.cbBroccoli);
		tomato = (CheckBox) findViewById(R.id.cbTomato);
		beans = (CheckBox) findViewById(R.id.cbBeans);
		rice = (CheckBox) findViewById(R.id.cbRice);
		pasta = (CheckBox) findViewById(R.id.cbPasta);
		bread = (CheckBox) findViewById(R.id.cbBread);
		tortilla = (CheckBox) findViewById(R.id.cbTortilla);
		potato = (CheckBox) findViewById(R.id.cbPotato);
	}

	public void savePref(){

		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();

		editor.putBoolean("chicken", chicken.isChecked());
		editor.putBoolean("beef", beef.isChecked());
		editor.putBoolean("pork", pork.isChecked());
		editor.putBoolean("fish", fish.isChecked());
		editor.putBoolean("lamb", lamb.isChecked());
		editor.putBoolean("mushrooms", mushrooms.isChecked());
		editor.putBoolean("lettuce", lettuce.isChecked());
		editor.putBoolean("broccoli", broccoli.isChecked());
		editor.putBoolean("tomato", tomato.isChecked());
		editor.putBoolean("beans", beans.isChecked());
		editor.putBoolean("rice", rice.isChecked());
		editor.putBoolean("pasta", pasta.isChecked());
		editor.putBoolean("bread", bread.isChecked());
		editor.putBoolean("tortilla", tortilla.isChecked());
		editor.putBoolean("potato", potato.isChecked());

		editor.commit();
	}
}