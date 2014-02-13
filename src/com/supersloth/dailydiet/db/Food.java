package com.supersloth.dailydiet.db;

/**
 * This class creates an instance of food
 * @author Hendrik Choy
 *
 */

public class Food {
	
	String _name;
	int _calories;
	String _category;
	
	public Food(){
		
	}
	
	public Food(String name,int calories, String category){
		this._name = name;
		this._calories = calories;
		this._category = category;
	}
	
	
	// getter and setter methods
	
	public String getName(){
		return this._name;
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public int getCalories(){
		return this._calories;
	}
	
	public void setCalories(int calories){
		this._calories = calories;
	}
	
	public String getCategory(){
		return this._category;
	}
	
	public void setCategory(String category){
		this._category = category;
	}
	
	@Override
	public String toString() {
		return this._calories + " calories - " + this._name;
	}
}
