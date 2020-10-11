package org.neshan.servicessdk.mapmatching;

import org.neshan.common.model.LatLng;
import org.neshan.common.network.RetrofitClientInstance;
import org.neshan.servicessdk.mapmatching.model.NeshanMapMatchingResult;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * The Map Matching API takes some GPS points collected along a route,
 * and returns a similar set of data, with the points snapped to
 * the most likely roads the vehicle was traveling along.
 * This class provides a model to call Neshan Map Matching Api.
 * see also <a href="https://developers.neshan.org/api/map-matching/">Neshan Direction Api</a>
 */
public class NeshanMapMatching {

    private String apiKey;
    private ArrayList<LatLng> path;


    public ArrayList<LatLng> getPath() {
        return path;
    }

    public NeshanMapMatching setPath(ArrayList<LatLng> path) {
        this.path = path;
        return this;
    }



    public void call(Callback<NeshanMapMatchingResult> callback){
        GetDataService api = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        String strPath="";
        for(LatLng LatLng:path){
            strPath+=(strPath.length()>0?"|":"")+LatLngToString(LatLng);
        }
        Call<NeshanMapMatchingResult> call = api.getNeshanMapMatching(apiKey, strPath);
        call.enqueue(callback);
    }


    private String LatLngToString(LatLng LatLng) {
        return LatLng.getLatitude()+","+LatLng.getLongitude();
    }

    public static class Builder {
        private ArrayList<LatLng> locations;
        private String apiKey;

        /**
         * new builder to create and initial a NeshanMapMatching instance.
         * @param apiKey Your application's API key.
         *        This key identifies your application for purposes of quota management.
         *       @see <a href="https://developers.neshan.org/api/getting-started/">How to get Api Key</a>
         *
         * @param path list of collected GPS points
         */
        public Builder(String apiKey, ArrayList<LatLng> path) {
            this.apiKey = apiKey;
            this.locations = path;
        }

        public NeshanMapMatching build(){
            NeshanMapMatching neshanSearch = new NeshanMapMatching();
            neshanSearch.apiKey = this.apiKey;
            neshanSearch.path = this.locations;
            return neshanSearch;
        }


        public Builder setLocations(ArrayList<LatLng> locations) {
            this.locations = locations;
            return this;
        }
    }

    interface GetDataService {

        @GET("/v1/map-matching")
        Call<NeshanMapMatchingResult> getNeshanMapMatching(@Header("Api-Key") String apiKey
                , @Query("path") String lat);
    }
}
