package com.supersloth.dailydiet.activities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.supersloth.dailydiet.R;

public class GroceryListActivity extends Activity{

	private Button bUpdateGroceryList;
	private CheckBox chicken, beef, pork, fish, lamb, mushrooms, lettuce, broccoli, 
		tomato, gbeans, rice, bread, tortilla, potato;
	ArrayList<String> protein = new ArrayList<String>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocerylist);
		
		bUpdateGroceryList = (Button)findViewById(R.id.bUpdateGroceryList);
		
		final Intent intent = new Intent(this, MainActivity.class);
		bUpdateGroceryList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast toast = Toast.makeText(getApplicationContext(), "update grocery list", Toast.LENGTH_SHORT);
				toast.show();
				
			}
		});
		
		// define checkboxes
		chicken = (CheckBox)findViewById(R.id.cbChicken);
		beef = (CheckBox)findViewById(R.id.cbBeef);
		pork = (CheckBox)findViewById(R.id.cbPork);
		fish = (CheckBox)findViewById(R.id.cbFish);
		lamb = (CheckBox)findViewById(R.id.cbLamb);
		mushrooms = (CheckBox)findViewById(R.id.cbMushrooms);
		lettuce = (CheckBox)findViewById(R.id.cbLettuce);
		broccoli = (CheckBox)findViewById(R.id.cbBroccoli);
		tomato = (CheckBox)findViewById(R.id.cbTomato);
		gbeans = (CheckBox)findViewById(R.id.cbBeans);
		rice = (CheckBox)findViewById(R.id.cbRice);
		bread = (CheckBox)findViewById(R.id.cbBread);
		tortilla = (CheckBox)findViewById(R.id.cbTortilla);
		potato = (CheckBox)findViewById(R.id.cbPotato);
		
		addListenerIngredients();

	}

	private void addListenerIngredients() {
		// TODO Auto-generated method stub
//		addListenerChicken();
//		addListenerBeef();
	}

//	private void addListenerBeef() {
//		beef = (CheckBox)findViewById(R.id.cbBeef);
//		beef.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast toast = Toast.makeText(getApplicationContext(), "beef works", Toast.LENGTH_SHORT);
//				toast.show();
//			}
//		});
//	}
//
//	private void addListenerChicken() {
//		chicken = (CheckBox)findViewById(R.id.cbChicken);
//		chicken.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast toast = Toast.makeText(getApplicationContext(), "chicken works", Toast.LENGTH_SHORT);
//				toast.show();
//			}
//		});
//	}
	
	public void onCheckBoxClicked(View view){
		boolean checked = ((CheckBox) view).isChecked();
	
		switch(view.getId()){
			case R.id.cbChicken:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "chicken works", Toast.LENGTH_SHORT);
					toast.show();
					protein.add("chicken");
					
				}
				break;
			case R.id.cbBeef:
				if(checked){
					Toast toast = Toast.makeText(getApplicationContext(), "beef works", Toast.LENGTH_SHORT);
					toast.show();
//					Groceries.proteins.add("beef");
				}
				break;
		}
	}

	

}
