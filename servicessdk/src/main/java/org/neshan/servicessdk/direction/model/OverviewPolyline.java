package org.neshan.servicessdk.direction.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Contains an encoded polyline information.
 * @see org.neshan.common.utils.PolylineEncoding
 */
public class OverviewPolyline implements Serializable {

    @SerializedName("points")
    private String encodedPolyline;

    /**
     * An encoded polyline information. After decoding will show an array of points
     * @see org.neshan.common.utils.PolylineEncoding
     */
    public String getEncodedPolyline() {
        return encodedPolyline;
    }

    public OverviewPolyline setEncodedPolyline(String encodedPolyline) {
        this.encodedPolyline = encodedPolyline;
        return this;
    }
}
