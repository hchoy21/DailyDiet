package com.supersloth.dailydiet.db;

/**
 * This class creates an instance of a Meal
 * Meal(name, protein, vegetable, carbs)
 * @author Hendrik Choy
 *
 */

public class Meal {
	
	int _id;
	String _name;
	String _protein;
	String _veg;
	String _carbs;
	
	public Meal(){
		
	}
	
	public Meal(String _name, String _protein, String _veg,
			String _carbs) {
		this._name = _name;
		this._protein = _protein;
		this._veg = _veg;
		this._carbs = _carbs;
	}

	public Meal(int _id, String _name, String _protein, String _veg,
			String _carbs) {
		this._id = _id;
		this._name = _name;
		this._protein = _protein;
		this._veg = _veg;
		this._carbs = _carbs;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_protein() {
		return _protein;
	}

	public void set_protein(String _protein) {
		this._protein = _protein;
	}

	public String get_veg() {
		return _veg;
	}

	public void set_veg(String _veg) {
		this._veg = _veg;
	}

	public String get_carbs() {
		return _carbs;
	}

	public void set_carbs(String _carbs) {
		this._carbs = _carbs;
	}

	public String mealToString() {
		return this._name;
	}
}
