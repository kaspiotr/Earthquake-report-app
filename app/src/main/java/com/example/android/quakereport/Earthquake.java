package com.example.android.quakereport;

public class Earthquake {

    private double magnitude;
    private String place;
    private long timeInMilliseconds;

    public Earthquake(double magnitude, String place, long date) {
        this.magnitude = magnitude;
        this.place = place;
        this.timeInMilliseconds = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getPlace() {
        return place;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }
}
