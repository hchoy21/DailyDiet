//package com.supersloth.dailydiet.activities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class Groceries implements Parcelable{
//
//	public List<String> proteins = new ArrayList<String>();
//	public List<String> veg = new ArrayList<String>();
//	public List<String> carbs = new ArrayList<String>();
//	
//	
//	public Groceries(List<String> proteins, List<String> veg, List<String> carbs) {
//		super();
//		this.proteins = proteins;
//		this.veg = veg;
//		this.carbs = carbs;
//	}
//	
//	public Groceries(Parcel source){
//		this.proteins = source.read
//	}
//	
//	public List<String> getProteins() {
//		return proteins;
//	}
//	public void setProteins(List<String> proteins) {
//		this.proteins = proteins;
//	}
//	public List<String> getVeg() {
//		return veg;
//	}
//	public void setVeg(List<String> veg) {
//		this.veg = veg;
//	}
//	public List<String> getCarbs() {
//		return carbs;
//	}
//	public void setCarbs(List<String> carbs) {
//		this.carbs = carbs;
//	}
//	
//	@Override
//	public int describeContents() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public void writeToParcel(Parcel dest, int flags) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}
