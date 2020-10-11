package org.neshan.servicessdk.distancematrix;

import org.neshan.common.model.LatLng;
import org.neshan.common.network.RetrofitClientInstance;
import org.neshan.servicessdk.distancematrix.model.NeshanDistanceMatrixResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * This class provides a model to call a Neshan Distance Matrix api request.
 * The Distance Matrix API is a service that provides travel distance and time for a matrix
 * of origins and destinations.
 * The API returns information based on the recommended route between start and end points,
 * as calculated by the Neshan Maps API, and consists of rows containing duration and distance values for each pair.
 * see also <a href="https://developers.neshan.org/api/distance-matrix/">Neshan Distance Matrix Api</a>
 */
public class NeshanDistanceMatrix {

    private String apiKey;
    private ArrayList<LatLng> origins;
    private ArrayList<LatLng> destinations;



    public void call(Callback<NeshanDistanceMatrixResult> callback){
        GetDataService api = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        String strOrigins="";
        for(LatLng LatLng:origins){
            strOrigins+=(strOrigins.length()>0?"|":"")+LatLngToString(LatLng);
        }
        String strDestinations="";
        for(LatLng LatLng:destinations){
            strDestinations+=(strDestinations.length()>0?"|":"")+LatLngToString(LatLng);
        }
        Call<NeshanDistanceMatrixResult> call = api.getNeshanDistanceMatrix(apiKey
                    , strOrigins
                    , strDestinations);

        call.enqueue(callback);
    }

    private String LatLngToString(LatLng LatLng) {
        return LatLng.getLatitude()+","+LatLng.getLongitude();
    }

    public static class Builder {
        private ArrayList<LatLng> origins;
        private ArrayList<LatLng> destinations;
        private String apiKey;

        /**
         * new builder to create and initial a {@link NeshanDistanceMatrix} instance.
         * @param apiKey Your application's API key.
         *        This key identifies your application for purposes of quota management.
         *       @see <a href="https://developers.neshan.org/api/getting-started/">How to get Api Key</a>
         *
         * @param origins Array of source addresses to calculate distances from.
         * @param destinations Array of destination addresses to calculate distances to.
         */
        public Builder(String apiKey,ArrayList<LatLng> origins,ArrayList<LatLng> destinations) {
            this.apiKey = apiKey;
            this.origins = origins;
            this.destinations = destinations;
        }

        public NeshanDistanceMatrix build(){
            NeshanDistanceMatrix neshanSearch = new NeshanDistanceMatrix();
            neshanSearch.apiKey = this.apiKey;
            neshanSearch.origins = this.origins;
            neshanSearch.destinations = this.destinations;
            return neshanSearch;
        }

        public ArrayList<LatLng> getOrigins() {
            return origins;
        }

        /**
         * Array of source addresses to calculate distances from.
         * @param origins
         * @return
         */
        public Builder setOrigins(ArrayList<LatLng> origins) {
            this.origins = origins;
            return this;
        }

        public ArrayList<LatLng> getDestinations() {
            return destinations;
        }

        /**
         * Array of destination addresses to calculate distances to.
         * @param destinations
         * @return
         */
        public Builder setDestinations(ArrayList<LatLng> destinations) {
            this.destinations = destinations;
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
        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }
    }

    interface GetDataService {

        @GET("/v1/distance-matrix")
        Call<NeshanDistanceMatrixResult> getNeshanDistanceMatrix(@Header("Api-Key") String apiKey
                , @Query("origins") String origins
                , @Query("destinations") String destinations);
    }
}
