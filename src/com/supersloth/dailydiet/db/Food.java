package com.supersloth.dailydiet.db;

/**
 * This class creates an instance of food
 * @author Hendrik Choy
 *
 */

public class Food {
	
	// private variables
	String _name;
	String _symptoms;
	int _calories;
	
	public Food(){
		
	}
	
	public Food(String name,int calories, String symptoms){
		this._name = name;
		this._calories = calories;
		this._symptoms = symptoms;
	}
	
	public Food(String name, int calories){
        this._name = name;
        this._calories = calories;
    }
	
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
	
	public String getSymptoms(){
		return this._symptoms;
	}
	
	public void setSymptoms(String symptoms){
		this._symptoms = symptoms;
	}
	
	@Override
	public String toString() {
		return this._calories + " calories - " + this._name;
	}
}
