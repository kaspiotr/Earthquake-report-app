package com.example.android.quakereport;

public class Earthquake {

    private String magnitude;
    private String place;
    private long timeInMilliseconds;

    public Earthquake(String magnitude, String place, long date) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMilliseconds = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }
}
