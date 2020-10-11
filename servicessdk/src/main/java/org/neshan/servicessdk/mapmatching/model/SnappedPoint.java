package org.neshan.servicessdk.mapmatching.model;

public class SnappedPoint {
    private Location location;
    private int originalIndex;

    public Location getLocation() {
        return location;
    }

    /**
     * original index shows this result is related to which point in requested points.
     * @return
     */
    public int getOriginalIndex() {
        return originalIndex;
    }
}
