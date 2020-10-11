package org.neshan.servicessdk.sample;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import org.neshan.common.model.LatLng;
import org.neshan.servicessdk.direction.NeshanDirection;
import org.neshan.servicessdk.direction.model.NeshanDirectionResult;
import org.neshan.servicessdk.distancematrix.NeshanDistanceMatrix;
import org.neshan.servicessdk.distancematrix.model.NeshanDistanceMatrixResult;
import org.neshan.servicessdk.georeverse.NeshanGeoReverse;
import org.neshan.servicessdk.georeverse.model.NeshanGeoReverseResult;
import org.neshan.servicessdk.mapmatching.NeshanMapMatching;
import org.neshan.servicessdk.mapmatching.model.NeshanMapMatchingResult;
import org.neshan.servicessdk.search.NeshanSearch;
import org.neshan.servicessdk.search.model.NeshanSearchResult;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new NeshanSearch.Builder("service.PnRV9ocd8zm9QYYlJUNLJoAihE3hfy34WUZ6jcjr")
                .setLocation(new LatLng(32.12254,52.365644))
                .setTerm("tehran")
                .build()
                .call(new Callback<NeshanSearchResult>() {

                    @Override
                    public void onResponse(Call<NeshanSearchResult> call, retrofit2.Response<NeshanSearchResult> response) {
                        Log.d("aaaaaaa",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<NeshanSearchResult> call, Throwable t) {
                        Log.d("aaaaaaa","ERROR");
                    }
                });

        new NeshanDirection.Builder("service.VNlPhrWb3wYRzEYmstQh3GrAXyhyaN55AqUSRR3V",new LatLng(32.12254,52.365644),new LatLng(32.13254,52.364644))
                .setAlternative(true)
                .setAvoidOddEvenZone(true)
                .build()
                .call(new Callback<NeshanDirectionResult>() {
                    @Override
                    public void onResponse(Call<NeshanDirectionResult> call, Response<NeshanDirectionResult> response) {
                        Log.d("aaaaaaa",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<NeshanDirectionResult> call, Throwable t) {
                        Log.d("aaaaaaa","Error");
                    }
                });

        new NeshanGeoReverse.Builder("service.vXnkREhrjgSh3cxveK09jcwRFb4YiJRNGf7yTpZd",new LatLng(32.12254,52.365644))
                .build()
                .call(new Callback<NeshanGeoReverseResult>() {
                    @Override
                    public void onResponse(Call<NeshanGeoReverseResult> call, Response<NeshanGeoReverseResult> response) {
                        Log.d("aaaaaaa",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<NeshanGeoReverseResult> call, Throwable t) {
                        Log.d("aaaaaaa","Error");
                    }
                });

        new NeshanMapMatching.Builder("service.vBVvOdBZubMJXcregZnD97DFwTvWotMU5HpUV1Tq",new ArrayList<>(Arrays.asList(new LatLng(36.299394,59.606211),new LatLng(36.297950,59.604258),new LatLng(36.297206,59.603507))))
                .build()
                .call(new Callback<NeshanMapMatchingResult>() {
                    @Override
                    public void onResponse(Call<NeshanMapMatchingResult> call, Response<NeshanMapMatchingResult> response) {
                        Log.d("aaaaaaa",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<NeshanMapMatchingResult> call, Throwable t) {
                        Log.d("aaaaaaa","Error");
                    }
                });

        new NeshanDistanceMatrix.Builder("service.7EX7XINl7FNueW9rOuswkmv3MrteDRKKvHRsqFOy"
                ,new ArrayList<>(Arrays.asList(new LatLng(36.299394,59.606211),new LatLng(36.297950,59.604258),new LatLng(36.297206,59.603507)))
                ,new ArrayList<>(Arrays.asList(new LatLng(36.299394,59.606211),new LatLng(36.297950,59.604258),new LatLng(36.297206,59.603507))))
                .build()
                .call(new Callback<NeshanDistanceMatrixResult>() {
                    @Override
                    public void onResponse(Call<NeshanDistanceMatrixResult> call, Response<NeshanDistanceMatrixResult> response) {
                        Log.d("aaaaaaa",response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<NeshanDistanceMatrixResult> call, Throwable t) {
                        Log.d("aaaaaaa","Error");
                    }
                });
    }
}