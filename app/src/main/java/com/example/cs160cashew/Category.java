package com.example.cs160cashew;

import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {

    String name = "untitled";
    int spending = 0;

    Category(String s){
        name = s;
    }

    protected Category(Parcel in) {
        name = in.readString();
        spending = in.readInt();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(name);
        parcel.writeInt(spending);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }
}
