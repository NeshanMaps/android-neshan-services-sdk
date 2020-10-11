package org.neshan.servicessdk.direction.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains information of a routing recieved from a Neshan direction api request.
 * see also <a href="https://developers.neshan.org/api/direction/">Neshan Direction Api</a>
 */
public class NeshanDirectionResult implements Serializable {

    private ArrayList<Route> routes;

    public ArrayList<Route> getRoutes() {
        return routes;
    }

    public NeshanDirectionResult setRoutes(ArrayList<Route> routes) {
        this.routes = routes;
        return this;
    }
}
