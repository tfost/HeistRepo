package com.parse.starter;

import com.parse.Parse;
import com.parse.ParseGeoPoint;

/**
 * Created by Tyler on 1/30/2016.
 */
public class Person {
    private boolean isTheif;
    private boolean isFound;
    private String name;
    private ParseGeoPoint location;

    public Person(String name, boolean isTheif, ParseGeoPoint location) {
        this.name = name;
        this.isTheif = isTheif;
        this.location = location;
    }

    public boolean isTheif() {
        return isTheif;
    }

    public void setIsTheif(boolean isTheif) {
        this.isTheif = isTheif;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setIsFound(boolean isFound) {
        this.isFound = isFound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParseGeoPoint getLocation() {
        return location;
    }

    public void setLocation(ParseGeoPoint location) {
        this.location = location;
    }
}
