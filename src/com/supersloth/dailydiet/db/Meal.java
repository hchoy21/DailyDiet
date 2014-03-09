package com.supersloth.dailydiet.db;

/**
 * This class creates an instance of a Meal
 * @author Hendrik Choy
 *
 */

public class Meal {
	
	String _name;
	String _category;
	
	public Meal(){
		
	}
	
	public Meal(String name, String category){
		this._name = name;
		this._category = category;
	}
	
	
	// getter and setter methods
	public String getName(){
		return this._name;
	}
	
	public void setName(String name){
		this._name = name;
	}
	
	public String getCategory(){
		return this._category;
	}
	
	public void setCategory(String category){
		this._category = category;
	}
	
	@Override
	public String toString() {
		return this._name;
	}
}
