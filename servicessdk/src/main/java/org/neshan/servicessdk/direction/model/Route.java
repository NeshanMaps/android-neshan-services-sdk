package org.neshan.servicessdk.direction.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Route implements Serializable {

    @SerializedName("overview_polyline")
    private OverviewPolyline overviewPolyline;

    private ArrayList<DirectionResultLeg> legs;

    /**
     * Get list of legs that each one represents a route between an two points.
     * ( origin and destination or waypoints )
     * @return
     */
    public ArrayList<DirectionResultLeg> getLegs() {
        return legs;
    }

    public Route setLegs(ArrayList<DirectionResultLeg> legs) {
        this.legs = legs;
        return this;
    }

    /**
     * An encoded polyline to draw the whole route approximately
     * @see org.neshan.common.utils.PolylineEncoding
     */
    public OverviewPolyline getOverviewPolyline() {
        return overviewPolyline;
    }

    public Route setOverviewPolyline(OverviewPolyline overviewPolyline) {
        this.overviewPolyline = overviewPolyline;
        return this;
    }
}
