package org.neshan.servicessdk.distancematrix.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains information of a distance matrix recieved from a Neshan DistanceMatrix api request.
 * see also <a href="https://developers.neshan.org/api/distance-matrix/">Neshan DistanceMatrix Api</a>
 */
public class NeshanDistanceMatrixResult implements Serializable {

    private String status;

    @SerializedName("origin_addresses")
    private ArrayList<String> originAddresses;

    @SerializedName("destination_addresses")
    private ArrayList<String> destinationAddresses;

    private ArrayList<DistanceMatrixRow> rows;

    public ArrayList<DistanceMatrixRow> getRows() {
        return rows;
    }

    public NeshanDistanceMatrixResult setRows(ArrayList<DistanceMatrixRow> rows) {
        this.rows = rows;
        return this;
    }

    /**
     * Arrays of destinations Latitude,Longitude addresses in String
     * @return
     */
    public ArrayList<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public NeshanDistanceMatrixResult setDestinationAddresses(ArrayList<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
        return this;
    }

    /**
     * Arrays of origins Latitude,Longitude addresses in String
     * @return
     */
    public ArrayList<String> getOriginAddresses() {
        return originAddresses;
    }

    public NeshanDistanceMatrixResult setOriginAddresses(ArrayList<String> originAddresses) {
        this.originAddresses = originAddresses;
        return this;
    }

    /**
     * Shows response status and successful status is "OK"
     * @return
     */
    public String getStatus() {
        return status;
    }

    public NeshanDistanceMatrixResult setStatus(String status) {
        this.status = status;
        return this;
    }
}
