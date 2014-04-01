package com.supersloth.dailydiet.db;

/**
 * This class creates an instance of a Meal
 * Meal(name, protein, vegetable, carbs)
 * @author Hendrik Choy
 *
 */

public class Meal {
	
	String _name;
	String _protein;
	String _veg;
	String _carbs;
	
	public Meal(){
		
	}
	
	public Meal(String name, String protein, String veg, String carbs){
		this._name = name;
		this._protein = protein;
		this._veg = veg;
		this._carbs = carbs;
	}
	
	
	// getter and setter methods
	public String getName(){
		return this._name;
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public String getProtein(){
		return this._protein;
	}
	
	public void setProtein(String protein){
		this._protein = protein;
	}
	
	public String getVeg(){
		return this._veg;
	}
	
	public void setVeg(String veg){
		this._veg = veg;
	}
	
	public String getCarbs(){
		return this._carbs;
	}
	
	public void setCarbs(String carbs){
		this._carbs = carbs;
	}
	
	public String mealToString() {
		return this._name;
	}
}
