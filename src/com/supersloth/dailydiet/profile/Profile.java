package com.supersloth.dailydiet.profile;

/**
 * Creates an instance of a profile for the user
 * to be used in local SQLite db
 * @author Hendrik Choy
 *
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable{
	
	/*
	this needs to be used for storing the user preferences and 
	depending on which button was pressed, save or load the preferences 
	into the right activity.
	
	activities that will be affected:
		main        - UserName        - load
		progress    - UpdateWeight    - save
				    - StartingWeight  - load
				    - GoalWeight	  - load
		Profile     - AllUserInfo	  - load
		EditProfile - AllUserInfo	  - save
	*/
	String userName;
	String weight;
	int age;
	int height;
	double startingWeight;
	double goalWeight;
	
	public Profile(Parcel source){
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getStartingWeight() {
		return startingWeight;
	}
	public void setStartingWeight(double startingWeight) {
		this.startingWeight = startingWeight;
	}
	public double getGoalWeight() {
		return goalWeight;
	}
	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}
	
	//public String getUserInfo(){
		
	//}
}
