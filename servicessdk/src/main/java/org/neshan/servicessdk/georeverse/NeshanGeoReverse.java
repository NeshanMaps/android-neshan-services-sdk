package org.neshan.servicessdk.georeverse;

import org.neshan.common.model.LatLng;
import org.neshan.common.network.RetrofitClientInstance;
import org.neshan.servicessdk.georeverse.model.NeshanGeoReverseResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Translating a location on the map into a human-readable address, is known as reverse geocoding
 * this class provides a model to call Neshan Reverse Geocoding api.
 * see also <a href="https://developers.neshan.org/api/reverse-geocoding/">Neshan Reverse Geocoding Api</a>
 */
public class NeshanGeoReverse {

    private String apiKey;
    private LatLng location;


    public LatLng getLocation() {
        return location;
    }

    public NeshanGeoReverse setLocation(LatLng location) {
        this.location = location;
        return this;
    }



    public void call(Callback<NeshanGeoReverseResult> callback){
        GetDataService api = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<NeshanGeoReverseResult> call = api.getNeshanGeoReverse(apiKey
                    , location.getLatitude()
                    , location.getLongitude());

        call.enqueue(callback);
    }

    public static class Builder {
        private LatLng location;
        private String apiKey;

        /**
         * new builder to create and initial a NeshanGeoReverse instance.
         * @param apiKey Your application's API key.
         *        This key identifies your application for purposes of quota management.
         *       @see <a href="https://developers.neshan.org/api/getting-started/">How to get Api Key</a>
         *
         * @param location place which to get human readable address
         */
        public Builder(String apiKey, LatLng location) {
            this.apiKey = apiKey;
            this.location = location;
        }

        public NeshanGeoReverse build(){
            NeshanGeoReverse neshanSearch = new NeshanGeoReverse();
            neshanSearch.apiKey = this.apiKey;
            neshanSearch.location = this.location;
            return neshanSearch;
        }


        public Builder setLocation(LatLng location) {
            this.location = location;
            return this;
        }
    }

    interface GetDataService {

        @GET("/v2/reverse")
        Call<NeshanGeoReverseResult> getNeshanGeoReverse(@Header("Api-Key") String apiKey
                , @Query("lat") Double lat
                , @Query("lng") Double lng);
    }
}
