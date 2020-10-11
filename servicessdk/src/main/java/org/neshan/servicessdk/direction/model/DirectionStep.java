package org.neshan.servicessdk.direction.model;

import com.google.gson.annotations.SerializedName;

import org.neshan.common.model.Distance;
import org.neshan.common.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A DirectionsStep is the most atomic unit of a direction's route,
 * containing a single step describing a specific, single instruction on the journey.
 * E.g. "Turn left at W. 4th St."
 * The step not only describes the instruction but also contains
 * distance and duration information relating to how this step relates to the following step.
 */
public class DirectionStep implements Serializable {
    private String name;
    private String instruction;
    private Distance distance;
    private Distance duration;
    private Maneuver maneuver;

    @SerializedName("start_location")
    private ArrayList<Double> startLocation;

    @SerializedName("polyline")
    private String encodedPolyline;

    /**
     * Name of the way ( road,alley,...) that step starts from
     */
    public String getName() {
        return name;
    }

    public DirectionStep setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * contains instructions for this step within a text string
     */
    public String getInstruction() {
        return instruction;
    }

    public DirectionStep setInstruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    /**
     * contains the distance covered by this step until the next step, as a {@link Distance} object.
     */
    public Distance getDistance() {
        return distance;
    }

    public DirectionStep setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    /**
     * duration contains an estimate of the time required to perform the step,
     * until the next step, as a {@link Distance} object
     */
    public Distance getDuration() {
        return duration;
    }

    public DirectionStep setDuration(Distance duration) {
        this.duration = duration;
        return this;
    }

    /**
     * contains the action to take for the current step as a {@link Maneuver} object
     * can be used to determine which icon to display
     * @return
     */
    public Maneuver getManeuver() {
        return maneuver;
    }

    public DirectionStep setManeuver(Maneuver maneuver) {
        this.maneuver = maneuver;
        return this;
    }

    /**
     * contains the location of the starting point of this step as a {@link LatLng}
     * @return
     */
    public LatLng getStartLocation() {
        if(startLocation!=null && startLocation.size()>1) {
            return new LatLng(startLocation.get(0), startLocation.get(1));
        }else {
            return null;
        }
    }

    public DirectionStep setStartLocation(LatLng startLocation) {
        this.startLocation = new ArrayList<>(Arrays.asList(startLocation.getLatitude(),startLocation.getLongitude()));
        return this;
    }

    /**
     * contains a single String object that holds an encoded polyline representation of the step.
     * This polyline is an approximate (smoothed) path of the step.
     * @see org.neshan.common.utils.PolylineEncoding
     */
    public String getEncodedPolyline() {
        return encodedPolyline;
    }

    public DirectionStep setEncodedPolyline(String encodedPolyline) {
        this.encodedPolyline = encodedPolyline;
        return this;
    }
}
