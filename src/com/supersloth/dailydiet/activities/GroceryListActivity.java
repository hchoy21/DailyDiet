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

public class GroceryListActivity extends Activity {
	private CheckBox chicken, beef, pork, fish, turkey, mushrooms, lettuce,
			broccoli, tomato, beans, rice, pasta, bread, tortilla, potato;
	private Button update;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocerylist);

		SharedPreferences sharPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		chicken = (CheckBox) findViewById(R.id.cbChicken);
		beef = (CheckBox) findViewById(R.id.cbBeef);
		pork = (CheckBox) findViewById(R.id.cbPork);
		fish = (CheckBox) findViewById(R.id.cbFish);
		turkey = (CheckBox) findViewById(R.id.cbTurkey);
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

		// set checkbox defaults to false
		chicken.setChecked(sharPrefs.getBoolean("chicken", false));
		beef.setChecked(sharPrefs.getBoolean("beef", false));
		pork.setChecked(sharPrefs.getBoolean("pork", false));
		fish.setChecked(sharPrefs.getBoolean("fish", false));
		turkey.setChecked(sharPrefs.getBoolean("turkey", false));
		mushrooms.setChecked(sharPrefs.getBoolean("mushrooms", false));
		lettuce.setChecked(sharPrefs.getBoolean("lettuce", false));
		broccoli.setChecked(sharPrefs.getBoolean("broccoli", false));
		tomato.setChecked(sharPrefs.getBoolean("tomato", false));
		beans.setChecked(sharPrefs.getBoolean("beans", false));
		rice.setChecked(sharPrefs.getBoolean("rice", false));
		pasta.setChecked(sharPrefs.getBoolean("pasta", false));
		bread.setChecked(sharPrefs.getBoolean("bread", false));
		tortilla.setChecked(sharPrefs.getBoolean("tortilla", false));
		potato.setChecked(sharPrefs.getBoolean("potato", false));

		update = (Button) findViewById(R.id.bUpdateGroceryList);
		update.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

//				Log.d("Test", "Update button clicked");
				Toast toast = Toast.makeText(getApplicationContext(),
						"Grocery List Updated!", Toast.LENGTH_SHORT);
				toast.show();
				savePref();
			}
		});
	}

	
	/**
	 * Checkboxes require onCheckBoxClicked method
	 */
	public void onCheckBoxClicked(View v) {

		boolean checked = ((CheckBox) v).isChecked();

		switch (v.getId()) {
		case R.id.cbChicken:
			break;
		case R.id.cbBeef:
			break;
		case R.id.cbPork:
			break;
		case R.id.cbFish:
			break;
		case R.id.cbTurkey:
			break;
		case R.id.cbMushrooms:
			break;
		case R.id.cbLettuce:
			break;
		case R.id.cbBroccoli:
			break;
		case R.id.cbTomato:
			break;
		case R.id.cbBeans:
			break;
		case R.id.cbRice:
			break;
		case R.id.cbPasta:
			break;
		case R.id.cbBread:
			break;
		case R.id.cbTortilla:
			break;
		case R.id.cbPotato:
			break;
		}

	}

	
	/**
	 * Saves the checkbox states as booleans to be recovered in another activity.
	 * Checkbox state is permanent until user uncheck or application uninstall
	 */
	public void savePref() {

		SharedPreferences sharPrefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharPrefs.edit();

		editor.putBoolean("chicken", chicken.isChecked());
		editor.putBoolean("beef", beef.isChecked());
		editor.putBoolean("pork", pork.isChecked());
		editor.putBoolean("fish", fish.isChecked());
		editor.putBoolean("turkey", turkey.isChecked());
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