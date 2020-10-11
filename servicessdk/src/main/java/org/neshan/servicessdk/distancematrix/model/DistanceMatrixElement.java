package org.neshan.servicessdk.distancematrix.model;

import org.neshan.common.model.Distance;

/**
 * The information about each origin-destination pairing is returned in an DistanceMatrixElement entry.
 */
public class DistanceMatrixElement {

    private DistanceMatrixElementStatus status;
    private Distance distance;
    private Distance duration;

    /**
     * The status field contain the status of an origin-destination pairing of the request
     * and can be:
     * OK
     * NO_ROUTE there is no route between this origin-destination pair.
     * UNKNOWN_ERROR some server side errors happened, retrying may solve the problem.
     * @return
     */
    public DistanceMatrixElementStatus getStatus() {
        return status;
    }

    public DistanceMatrixElement setStatus(DistanceMatrixElementStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Total distance of the route between origin and destination in meter and readable text.
     * @return
     */
    public Distance getDistance() {
        return distance;
    }

    public DistanceMatrixElement setDistance(Distance distance) {
        this.distance = distance;
        return this;
    }

    /**
     * The length of time it takes to travel this route in minutes and readable text.
     * @return
     */
    public Distance getDuration() {
        return duration;
    }

    public DistanceMatrixElement setDuration(Distance duration) {
        this.duration = duration;
        return this;
    }
}
