package com.supersloth.dailydiet.profile;

/**
 * Creates an instance of a profile for the user
 * to be used in local SQLite db
 * @author Hendrik Choy
 *
 */
public class Profile {
	
	int _id;
	String _firstName;
	String _lastName;
	String _gender;
	
	public Profile(){
		
	}
	
	public Profile(int id, String first, 
			String last, String gender){
		_id = id;
		_firstName = first;
		_lastName = last;
		_gender = gender;
	}
	
	public int getId(){
		return _id;
	}
	
	public void setId(int id){
		_id = id;
	}
	
	public String getFirstName(){
		return _firstName;
	}
	
	public void setFirstName(String first){
		_firstName = first;
	}
	
	public String getLastName(){
		return _lastName;
	}
	
	public void setLastName(String last){
		_lastName = last;
	}
	
	public String getGender(){
		return _gender;
	}
	
	public void setGender(String gender){
		_gender = gender;
	}
}
