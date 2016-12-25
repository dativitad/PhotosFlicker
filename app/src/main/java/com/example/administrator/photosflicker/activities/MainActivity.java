package com.example.administrator.photosflicker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.adapters.CardsDataAdapter;
import com.example.administrator.photosflicker.interfaces.RequestListener;
import com.example.administrator.photosflicker.interfaces.RestAPI;
import com.example.administrator.photosflicker.models.RootPhotosModel;
import com.example.administrator.photosflicker.models.RootPhotosetsListModel;
import com.example.administrator.photosflicker.utils.Constants;
import com.example.administrator.photosflicker.utils.RestAPICommunicator;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RequestListener {

    public static final String TAG = "MainActivity";
    private CardsDataAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        dummyMethod();
    }

    private void dummyMethod() {
        RestAPI calls = RestAPICommunicator.getInstance().getCalls();
        calls.getPhotosetsList(Constants.PHOTOSETS_LIST_METHOD)
                .enqueue(new Callback<RootPhotosetsListModel>() {
                    @Override
                    public void onResponse(Call<RootPhotosetsListModel> call, Response<RootPhotosetsListModel> response) {
                        Log.d(TAG, "onResponse: getPhotosetsList !!!");
                        Log.d(TAG, "onResponse: rootModel = "+response.body());
                    }

                    @Override
                    public void onFailure(Call<RootPhotosetsListModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: getPhotosetsList !!!");
                    }
                });

        calls.getPhotosetPhotos(
                Constants.PHOTOSET_PHOTOS_METHOD,
                72157676595604961L
        ).enqueue(new Callback<RootPhotosModel>() {
            @Override
            public void onResponse(Call<RootPhotosModel> call, Response<RootPhotosModel> response) {

            }

            @Override
            public void onFailure(Call<RootPhotosModel> call, Throwable t) {

            }
        });
    }

    private void init() {
        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.swipeFlingAdapterView);

        final List<String> stringList = new ArrayList<>(5);
        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        stringList.add("test4");
        stringList.add("test5");

        cardAdapter = new CardsDataAdapter(getApplicationContext(), stringList);

        swipeFlingAdapterView.setAdapter(cardAdapter);
        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                Log.d(TAG, "onItemClicked: i = "+ i +" o = "+o);
            }
        });
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                stringList.remove(0);
                cardAdapter.notifyDataSetChanged();
                Log.d(TAG, "removeFirstObjectInAdapter: !!!");
            }

            @Override
            public void onLeftCardExit(Object o) {
                Log.d(TAG, "onLeftCardExit: o = "+o);
            }

            @Override
            public void onRightCardExit(Object o) {
                Log.d(TAG, "onRightCardExit: o = "+o);
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                Log.d(TAG, "onAdapterAboutToEmpty: i = "+i);
            }

            @Override
            public void onScroll(float v) {
                Log.d(TAG, "onScroll: v = "+v);
            }
        });

    }

    @Override
    public void startPhotoFlickerFragment() {

    }

    @Override
    public void startDetailsFragment() {

    }
}
