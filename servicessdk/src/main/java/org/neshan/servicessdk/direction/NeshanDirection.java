package org.neshan.servicessdk.direction;

import org.neshan.common.model.LatLng;
import org.neshan.common.network.RetrofitClientInstance;
import org.neshan.servicessdk.direction.model.NeshanDirectionResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * This class provides a model to call a Neshan direction api request.
 * The Directions API allows the calculation of routes between coordinates.
 * The fastest route can be returned with geometries, turn-by-turn instructions, and much more.
 * The Neshan Directions API supports routing for driving cars (including live traffic) and riding bicycles.
 * Requesting a route at a bare minimal must include, a Neshan apiKey, destination, and an origin.
 * see also <a href="https://developers.neshan.org/api/direction/">Neshan Direction Api</a>
 */
public class NeshanDirection {

    private LatLng sourceLocation;
    private LatLng destinationLocation;
    private String apiKey;
    private Boolean avoidTrafficZone;
    private Boolean avoidOddEvenZone;
    private Boolean alternative;
    private ArrayList<LatLng> waypoints=new ArrayList<>();

    public LatLng getSourceLocation() {
        return sourceLocation;
    }

    /**
     * set origin location
     * @param sourceLocation The location where you wish to calculate directions from
     */
    public NeshanDirection setSourceLocation(LatLng sourceLocation) {
        this.sourceLocation = sourceLocation;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    /**
     *  Your application's API key.
     *  This key identifies your application for purposes of quota management.
     *
     * @see <a href="https://developers.neshan.org/api/getting-started/">How to get Api Key</a>
     * @param apiKey
     * @return
     */
    public NeshanDirection setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public void call(Callback<NeshanDirectionResult> callback){
        GetDataService api = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<NeshanDirectionResult> call ;
        if(waypoints.size()==0 || waypoints==null) {
            call = api.getNeshanDirection(apiKey
                    , LatLngToString(sourceLocation)
                    , LatLngToString(destinationLocation)
                    , avoidTrafficZone
                    , avoidOddEvenZone
                    , alternative);
        }else {
            String strWaypoints="";
            for (LatLng LatLng:waypoints) {
                strWaypoints+=(strWaypoints.length()>0?"|":"")+LatLngToString(LatLng);
            }
            call = api.getNeshanDirection(apiKey
                    , LatLngToString(sourceLocation)
                    , LatLngToString(destinationLocation)
                    , strWaypoints
                    , avoidTrafficZone
                    , avoidOddEvenZone
                    , alternative);
        }

        call.enqueue(callback);
    }

    private String LatLngToString(LatLng LatLng) {
        return LatLng.getLatitude()+","+LatLng.getLongitude();
    }

    public LatLng getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * The destination point where you wish to calculate directions to
     * @param destinationLocation
     * @return
     */
    public NeshanDirection setDestinationLocation(LatLng destinationLocation) {
        this.destinationLocation = destinationLocation;
        return this;
    }

    public Boolean getAvoidTrafficZone() {
        return avoidTrafficZone;
    }

    /**
     * if True, suggested routes will not enter traffic restricted areas.
     * if destination be in restricted area, no route will be found.
     * @param avoidTrafficZone
     * @return
     */
    public NeshanDirection setAvoidTrafficZone(Boolean avoidTrafficZone) {
        this.avoidTrafficZone = avoidTrafficZone;
        return this;
    }

    public Boolean getAvoidOddEvenZone() {
        return avoidOddEvenZone;
    }

    /**
     * if True, suggested routes will not enter Tehran Odd/Even restricted area.
     * and if destination be in restricted area, no route will be found.
     *
     * for other cities without Odd/Even restricted area,
     * it works as {@see #setAvoidTrafficZone(Boolean) setAvoidTrafficZone}
     * @param avoidOddEvenZone
     * @return
     */
    public NeshanDirection setAvoidOddEvenZone(Boolean avoidOddEvenZone) {
        this.avoidOddEvenZone = avoidOddEvenZone;
        return this;
    }

    public Boolean getAlternative() {
        return alternative;
    }

    /**
     * if True, alternative directions will be suggested.
     * if False, response will only contains the best direction.
     * @param alternative
     * @return
     */
    public NeshanDirection setAlternative(Boolean alternative) {
        this.alternative = alternative;
        return this;
    }

    public ArrayList<LatLng> getWaypoints() {
        return waypoints;
    }

    /**
     * Specifies an array of intermediate locations to include
     * along the route between the origin and destination points as pass through or stopover locations.
     * @param waypoints
     * @return
     */
    public NeshanDirection setWaypoints(ArrayList<LatLng> waypoints) {
        this.waypoints = waypoints;
        return this;
    }

    public static class Builder {
        private LatLng sourceLocation;
        private LatLng destinationLocation;
        private String apiKey;
        private Boolean avoidTrafficZone=false;
        private Boolean avoidOddEvenZone=false;
        private Boolean alternative=false;
        private ArrayList<LatLng> waypoints=new ArrayList<>();

        public Builder(String apiKey,LatLng sourceLocation,LatLng destinationLocation) {
            this.apiKey = apiKey;
            this.destinationLocation = destinationLocation;
            this.sourceLocation = sourceLocation;
        }

        public NeshanDirection build(){
            NeshanDirection neshanSearch = new NeshanDirection();
            neshanSearch.apiKey = this.apiKey;
            neshanSearch.sourceLocation = this.sourceLocation;
            neshanSearch.destinationLocation = this.destinationLocation;
            neshanSearch.avoidTrafficZone = this.avoidTrafficZone;
            neshanSearch.avoidOddEvenZone = this.avoidOddEvenZone;
            neshanSearch.alternative = this.alternative;
            neshanSearch.waypoints = this.waypoints;
            return neshanSearch;
        }


        public Builder setAvoidTrafficZone(Boolean avoidTrafficZone) {
            this.avoidTrafficZone = avoidTrafficZone;
            return this;
        }

        public Builder setAvoidOddEvenZone(Boolean avoidOddEvenZone) {
            this.avoidOddEvenZone = avoidOddEvenZone;
            return this;
        }

        public Builder setAlternative(Boolean alternative) {
            this.alternative = alternative;
            return this;
        }

        public Builder setSourceLocation(LatLng sourceLocation) {
            this.sourceLocation = sourceLocation;
            return this;
        }

        public Builder setDestinationLocation(LatLng destinationLocation) {
            this.destinationLocation = destinationLocation;
            return this;
        }
    }

    interface GetDataService {

        @GET("/v2/direction")
        Call<NeshanDirectionResult> getNeshanDirection(@Header("Api-Key") String apiKey
                , @Query("origin") String origin
                , @Query("destination") String destination
                , @Query("waypoints") String waypoints
                , @Query("avoidTrafficZone") boolean avoidTrafficZone
                , @Query("avoidOddEvenZone") boolean avoidOddEvenZone
                , @Query("alternative") boolean alternative);

        @GET("/v2/direction")
        Call<NeshanDirectionResult> getNeshanDirection(@Header("Api-Key") String apiKey
                , @Query("origin") String origin
                , @Query("destination") String destination
                , @Query("avoidTrafficZone") boolean avoidTrafficZone
                , @Query("avoidOddEvenZone") boolean avoidOddEvenZone
                , @Query("alternative") boolean alternative);
    }
}
