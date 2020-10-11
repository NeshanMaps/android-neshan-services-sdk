package org.neshan.servicessdk.distancematrix.model;

import com.google.gson.annotations.SerializedName;

/**
 * The status field contain the status of an origin-destination pairing of the request
 * and can be:
 * OK
 * NO_ROUTE there is no route between this origin-destination pair.
 * UNKNOWN_ERROR some server side errors happened, retrying may solve the problem.
 * @return
 */
public enum DistanceMatrixElementStatus {

    @SerializedName("NoRoute")
    NO_ROUTE
    ,@SerializedName("UnknownError")
    UNKNOWN_ERROR
    ,@SerializedName("Ok")
    OK
}
