package org.neshan.servicessdk.mapmatching.model;


import org.neshan.common.model.LatLng;

public class Location {
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public Location setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public Location setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
    public LatLng toLatLng(){
        return new LatLng(latitude,longitude);
    }
}
