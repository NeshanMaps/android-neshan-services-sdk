package org.neshan.servicessdk.georeverse.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class NeshanGeoReverseResult implements Serializable {

    private String status;

    @SerializedName("formatted_address")
    private String formattedAddress;

    @SerializedName("route_name")
    private String routeName;

    @SerializedName("route_type")
    private String routeType;

    private String neighbourhood;

    private String city;

    private String state;

    private String place;

    @SerializedName("municipality_zone")
    private String municipalityZone;

    @SerializedName("in_traffic_zone")
    private Boolean inTrafficZone;

    @SerializedName("in_odd_even_zone")
    private Boolean inOddEvenZone;

    private ArrayList<Address> addresses;

    /**
     * Shows response status and successful status is "OK"
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Complete address of requested point.
     * contains province, city, the nejghbourhood, street, ...
     * @return
     */
    public String getFormattedAddress() {
        return formattedAddress;
    }

    /**
     * The last street of the address
     * @return
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * Type of the last street of the address
     * @return
     */
    public String getRouteType() {
        return routeType;
    }

    /**
     * The neighbourhood name ( if exist )
     * @return
     */
    public String getNeighbourhood() {
        return neighbourhood;
    }

    /**
     * The city name
     * @return
     */
    public String getCity() {
        return city;
    }


    /**
     * The state name
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * Name of the public place which selected point is inside it. ( if exist )
     * @return
     */
    public String getPlace() {
        return place;
    }

    /**
     * Get the regional municipality if exist.
     * @return
     */
    public String getMunicipalityZone() {
        return municipalityZone;
    }

    /**
     * returns True if the requested address is inside a traffic restricted area
     * @return
     */
    public Boolean getInTrafficZone() {
        return inTrafficZone;
    }

    /**
     * returns True if the requested address is inside the Tehran's odd/even restricted area
     * @return
     */
    public Boolean getInOddEvenZone() {
        return inOddEvenZone;
    }

    /**
     * Array of generated addresses for the requested point
     * @return
     */
    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}
