package org.neshan.servicessdk.search.model;

import com.google.gson.annotations.SerializedName;

import org.neshan.common.model.LatLng;

import java.io.Serializable;

public class Location implements Serializable {

    @SerializedName("y")
    private double latitude;

    @SerializedName("x")
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LatLng getLatLng(){
        return new LatLng(latitude,longitude);
    }
}
