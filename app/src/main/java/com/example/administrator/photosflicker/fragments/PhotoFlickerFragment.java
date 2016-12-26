package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.adapters.CardsDataAdapter;
import com.example.administrator.photosflicker.models.Photo;
import com.example.administrator.photosflicker.models.RootPhotosModel;
import com.example.administrator.photosflicker.utils.Constants;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 26.12.2016.
 */

public class PhotoFlickerFragment extends BaseFragment {

    public static final String TAG = "PhotoFlickerFragment";

    @BindView(R.id.swipeFlingAdapterView) SwipeFlingAdapterView swipeFlingAdapterView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(
                R.layout.fragment_photoflicker,
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

        calls.getPhotosetPhotos(
                Constants.PHOTOSET_PHOTOS_METHOD,
                72157676595604961L
        ).enqueue(new Callback<RootPhotosModel>() {
            @Override
            public void onResponse(Call<RootPhotosModel> call, Response<RootPhotosModel> response) {
                Log.d(TAG, "onResponse: getPhotosetPhotos !!!");
                if(response.code() == Constants.CODE_OK) {
                    initData(response.body().getPhotoset().getPhoto());
                }
            }

            @Override
            public void onFailure(Call<RootPhotosModel> call, Throwable t) {
                Log.d(TAG, "onFailure: getPhotosetPhotos !!!");
            }
        });
    }

    private void initData(final List<Photo> photosList) {

        final ArrayAdapter cardAdapter = new CardsDataAdapter(getContext(), photosList);

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
                photosList.remove(0);
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
                if(i == 0) {
                    requestListener.popBackStack();
                }
            }

            @Override
            public void onScroll(float v) {
                Log.d(TAG, "onScroll: v = "+v);
            }
        });
    }
}
