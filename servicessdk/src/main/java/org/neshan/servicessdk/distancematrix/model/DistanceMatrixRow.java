package org.neshan.servicessdk.distancematrix.model;

import java.util.ArrayList;

/**
 * A row of the DistanceMatrix request response.
 */
public class DistanceMatrixRow {

    private ArrayList<DistanceMatrixElement> elements;

    public ArrayList<DistanceMatrixElement> getElements() {
        return elements;
    }

    public DistanceMatrixRow setElements(ArrayList<DistanceMatrixElement> elements) {
        this.elements = elements;
        return this;
    }
}
