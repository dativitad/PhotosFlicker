package com.example.administrator.photosflicker.fragments;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.administrator.photosflicker.PhotosFlickerApp;
import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.adapters.CardsDataAdapter;
import com.example.administrator.photosflicker.interfaces.RestAPI;
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

    private ImageView hateIcon;
    private ImageView likeIcon;

    private Call<RootPhotosModel> rootPhotoModelCall;

    @BindView(R.id.swipeFlingAdapterView) SwipeFlingAdapterView swipeFlingAdapterView;
    @BindView(R.id.progress) ProgressBar progress;

    public static PhotoFlickerFragment newInstance(long photosetId) {

        Bundle args = new Bundle();

        PhotoFlickerFragment fragment = new PhotoFlickerFragment();
        args.putLong(Constants.PHOTOSET_ID, photosetId);
        fragment.setArguments(args);
        return fragment;
    }

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

        long photosetId = getArguments().getLong(Constants.PHOTOSET_ID);
        progress.getIndeterminateDrawable().setColorFilter(
                ContextCompat.getColor(getContext(), R.color.lightBrown),
                PorterDuff.Mode.MULTIPLY
        );
        sendCall(photosetId);

    }

    private void sendCall(long photosetId) {

        rootPhotoModelCall = calls.getPhotosetPhotos(
                Constants.PHOTOSET_PHOTOS_METHOD,
                photosetId
        );

        rootPhotoModelCall.enqueue(new Callback<RootPhotosModel>() {
            @Override
            public void onResponse(Call<RootPhotosModel> call, Response<RootPhotosModel> response) {
                Log.d(TAG, "onResponse: getPhotosetPhotos !!!");
                if(response.code() == Constants.CODE_OK) {
                    initData(response.body().getPhotoset().getPhoto());
                    progress.setVisibility(View.GONE);
                    return;
                }
                Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RootPhotosModel> call, Throwable t) {
                Log.d(TAG, "onFailure: getPhotosetPhotos !!! t = "+t);
                if(!t.getMessage().equals(Constants.CANCELED)) {
                    Toast.makeText(getContext(), getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void initData(final List<Photo> photosList) {

        final CardsDataAdapter cardAdapter = new CardsDataAdapter(
                getContext(),
                photosList
        );

        swipeFlingAdapterView.setAdapter(cardAdapter);
        cardAdapter.notifyDataSetChanged();
        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object photo) {
                Log.d(TAG, "onItemClicked: i = "+ i +" photo = "+photo);

                requestListener.startDetailsFragment((Photo) photo);
            }
        });
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                cardAdapter.removeFirstObject();
                hateIcon = null;
                Log.d(TAG, "removeFirstObjectInAdapter: !!!");
            }

            @Override
            public void onLeftCardExit(Object photo) {
                Log.d(TAG, "onLeftCardExit: o = "+photo);
            }

            @Override
            public void onRightCardExit(Object photo) {
                Log.d(TAG, "onRightCardExit: o = "+photo);
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
                if(hateIcon == null) {
                    hateIcon = (ImageView) swipeFlingAdapterView.getSelectedView().findViewById(R.id.hateIcon);
                    likeIcon = (ImageView) swipeFlingAdapterView.getSelectedView().findViewById(R.id.likeIcon);
                }

                if(v < 0) {
                    smartSetViewAlpha(hateIcon, Math.abs(v));
                } else if (v > 0) {
                    smartSetViewAlpha(likeIcon, v);
                } else if(v == 0) {
                    smartSetViewAlpha(hateIcon, v);
                    smartSetViewAlpha(likeIcon, v);
                }

            }
        });
    }

    private void smartSetViewAlpha(View view, float alpha) {
        if(view.getAlpha() != alpha) {
            view.setAlpha(alpha);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if(!rootPhotoModelCall.isCanceled()) {
            rootPhotoModelCall.cancel();
        }

    }

}
