package org.neshan.servicessdk.direction.model;

import com.google.gson.annotations.SerializedName;

import org.neshan.common.model.Distance;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Each DirectionResultLeg represents a route between an origin and a destination.
 * For routes that contain no waypoints, the route will consist of a single "leg,"
 * but for routes that define one or more waypoints,
 * the route will consist of one or more legs
 */
public class DirectionResultLeg implements Serializable {
    private String summary;
    private Distance distance;
    private Distance duration;

    @SerializedName("steps")
    private ArrayList<DirectionStep> directionSteps;

    /**
     * a summary of the route that usually contains 2 major streets of
     * start and end of the journey.
     * summary helps to know the route approximately.
     */
    public String getSummary() {
        return summary;
    }

    public DirectionResultLeg setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * contains the total distance covered by this leg, as a {@link Distance} object.
     */
    public Distance getDistance() {
        return distance;
    }

    public DirectionResultLeg setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    /**
     * duration contains an estimate of the time required
     * to perform the whole leg as a {@link Distance} object
     */
    public Distance getDuration() {
        return duration;
    }

    public DirectionResultLeg setDuration(Distance duration) {
        this.duration = duration;
        return this;
    }

    /**
     * contains an array of steps denoting information about each separate step of the leg of the journey.
     * @see DirectionStep
     * @return
     */
    public ArrayList<DirectionStep> getDirectionSteps() {
        return directionSteps;
    }

    public DirectionResultLeg setDirectionSteps(ArrayList<DirectionStep> directionSteps) {
        this.directionSteps = directionSteps;
        return this;
    }
}
