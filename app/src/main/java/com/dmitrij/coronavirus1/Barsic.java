package com.dmitrij.coronavirus1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

class Z implements Parcelable{
    private int a;

    protected Z(Parcel in) {
        a = in.readInt();
    }

    public static final Creator<Z> CREATOR = new Creator<Z>() {
        @Override
        public Z createFromParcel(Parcel in) {
            return new Z(in);
        }

        @Override
        public Z[] newArray(int size) {
            return new Z[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(a);
    }
}

public class Barsic implements Parcelable {
    int age;
    String name;
    ArrayList<String> katzen;
    ArrayList<Z> z;
    transient int year; // no serialization
    static int age2; // no serialization
    transient final int year1 = 2020;

    public Barsic(int age, String name, ArrayList<String> katzen, ArrayList<Z> z) {
        this.age = age;
        this.name = name;
        this.katzen = katzen;
        this.z = z;
    }

    protected Barsic(Parcel in) {
        Bundle bundle = in.readBundle();
        age = bundle.getInt("age");
        name = bundle.getString("name");
        katzen = bundle.getStringArrayList("katzen");
        z = bundle.getParcelableArrayList("z");
    }

    public static final Creator<Barsic> CREATOR = new Creator<Barsic>() {
        @Override
        public Barsic createFromParcel(Parcel in) {
            return new Barsic(in);
        }

        @Override
        public Barsic[] newArray(int size) {
            return new Barsic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        Bundle bundle = new Bundle();
        bundle.putInt("age", age);
        bundle.putString("name", name);
        bundle.putStringArrayList("katzen", katzen);
        bundle.putParcelableArrayList("z", z);
        parcel.writeBundle(bundle);

    }
    //private final static long serialVersionUID = 13L;
}
