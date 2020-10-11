package org.neshan.servicessdk.georeverse.model;

import java.util.ArrayList;

/**
 * Each address contains a formatted complete address in String
 * an a list of address components that shows name and type of different parts of the address
 */
public class Address {

    private String formatted;
    private ArrayList<AddressComponent> components;

    public String getFormatted() {
        return formatted;
    }

    public ArrayList<AddressComponent> getComponents() {
        return components;
    }
}
