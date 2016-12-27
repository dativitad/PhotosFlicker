package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.photosflicker.PhotosFlickerApp;
import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.adapters.PhotosetsAdapter;
import com.example.administrator.photosflicker.models.Photoset;
import com.example.administrator.photosflicker.models.RootPhotosetsListModel;
import com.example.administrator.photosflicker.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 26.12.2016.
 */

public class PhotosetsFragment extends BaseFragment {

    public static final String TAG = "PhotosetsFragment";
    @BindView(R.id.photosetsRecycleView) RecyclerView photosetsRecycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(
                R.layout.fragment_photosets,
                container,
                false
        );
        ButterKnife.bind(this, root);
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sendCall();
    }

    private void sendCall() {
        calls.getPhotosetsList(Constants.PHOTOSETS_LIST_METHOD)
                .enqueue(new Callback<RootPhotosetsListModel>() {
                    @Override
                    public void onResponse(Call<RootPhotosetsListModel> call, Response<RootPhotosetsListModel> response) {
                        Log.d(TAG, "onResponse: getPhotosetsList !!!");
                        if(response.code() == Constants.CODE_OK) {
                            initData(response.body().getPhotosets().getPhotoset());
                            requestListener.hideSplashScreen();
                            return;
                        }
                        Toast.makeText(PhotosFlickerApp.getAppContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RootPhotosetsListModel> call, Throwable t) {
                        Log.d(TAG, "onFailure: getPhotosetsList !!!");

                        Toast.makeText(PhotosFlickerApp.getAppContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void initData(List<Photoset> photoset) {
        RecyclerView.Adapter photosetsAdapter = new PhotosetsAdapter(
                photoset,
                requestListener
        );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        photosetsRecycleView.setHasFixedSize(true);
        photosetsRecycleView.setLayoutManager(layoutManager);
        photosetsRecycleView.setAdapter(photosetsAdapter);
    }

}
