package org.neshan.servicessdk.search;

import org.neshan.common.model.LatLng;
import org.neshan.common.network.RetrofitClientInstance;
import org.neshan.servicessdk.search.model.NeshanSearchResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Search Api returns a list of places based on a location and a search string
 * this class provides a model to call Neshan Search api.
 * see also <a href="https://developers.neshan.org/api/search/">Neshan Search Api</a>
 */
public class NeshanSearch {

    private LatLng location;
    private String term;
    private String apiKey;

    public LatLng getLocation() {
        return location;
    }

    /**
     * set center point to search around it
     * @param location
     * @return
     */
    public NeshanSearch setLocation(LatLng location) {
        this.location = location;
        return this;
    }

    public String getTerm() {
        return term;
    }


    /**
     * set string text to search
     * @param term
     * @return
     */
    public NeshanSearch setTerm(String term) {
        this.term = term;
        return this;
    }

    public void call(Callback<NeshanSearchResult> callback){
        GetDataService api = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<NeshanSearchResult> call = api.getNeshanSearch(apiKey,location.getLatitude(),location.getLongitude(),term);

        call.enqueue(callback);
    }

    public static class Builder {
        private String apiKey;
        private String term;
        private LatLng location;

        /**
         * new builder to create and initial a NeshanGeoReverse instance.
         * @param apiKey Your application's API key.
         *        This key identifies your application for purposes of quota management.
         *       @see <a href="https://developers.neshan.org/api/getting-started/">How to get Api Key</a>
         *
         */
        public Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        public NeshanSearch build(){
            NeshanSearch neshanSearch = new NeshanSearch();
            neshanSearch.apiKey = this.apiKey;
            neshanSearch.term = this.term;
            neshanSearch.location = this.location;
            return neshanSearch;
        }

        public Builder setTerm(String term) {
            this.term = term;
            return this;
        }

        public Builder setLocation(LatLng location) {
            this.location = location;
            return this;
        }
    }

    interface GetDataService {

        @GET("/v1/search")
        Call<NeshanSearchResult> getNeshanSearch(@Header("Api-Key") String apiKey, @Query("lat") Double lat, @Query("lng") Double lng, @Query("term") String query);
    }
}
