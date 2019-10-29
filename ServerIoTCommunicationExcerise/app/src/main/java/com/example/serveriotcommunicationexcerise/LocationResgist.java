package com.example.serveriotcommunicationexcerise;

import java.util.ArrayList;

public class LocationResgist {
    static ArrayList<Location> locationsList;

    public  ArrayList<Location> getLocationsList() {
        return locationsList;
    }

    public  void setLocationsList(ArrayList<Location> locationsList) {
        LocationResgist.locationsList = locationsList;
    }
}
class Location{
        double lat;
        double lon;

    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}