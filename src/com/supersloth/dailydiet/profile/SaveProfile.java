package com.supersloth.dailydiet.profile;

import android.os.Parcel;
import android.os.Parcelable;
 
public class SaveProfile implements Parcelable {
     
    String name;
    int age;
    int height;
    double startWeight;
    double goalWeight;
    double progress;
     
    public double getProgress() {
        return progress;
    }
    public void setProgress(double progress) {
        this.progress = progress;
    }
    public double getStartWeight() {
        return startWeight;
    }
    public void setStartWeight(double startWeight) {
        this.startWeight = startWeight;
    }
    public double getGoalWeight() {
        return goalWeight;
    }
    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static Parcelable.Creator<SaveProfile> getCreator() {
        return Creator;
    }
     
    public SaveProfile(String userName, int progress, double startWeight, double goalWeight, double userGoal, double userProgress) {
        super();
        this.progress = progress;
        this.startWeight = startWeight;
        this.goalWeight = goalWeight;
    }
     
    public SaveProfile(Parcel source) {
         
        progress = source.readDouble();
        startWeight = source.readDouble();
        goalWeight = source.readDouble();
         
    }
 
    public SaveProfile(String userName, int userAge, int userHeight,
            double userWeight, double userGoal) {
        // TODO Auto-generated constructor stub
    }
 
    public static final Parcelable.Creator<SaveProfile> Creator = new Parcelable.Creator<SaveProfile>() {
 
        @Override
        public SaveProfile createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new SaveProfile(source);
        }
 
        @Override
        public SaveProfile[] newArray(int size) {
            // TODO Auto-generated method stub
            return new SaveProfile[size];
        }
    };
     
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }
     
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeDouble(progress);
        dest.writeDouble(startWeight);
        dest.writeDouble(goalWeight);
    }
     
     
 
}