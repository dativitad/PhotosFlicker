package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.models.RootPhotosModel;
import com.example.administrator.photosflicker.utils.Constants;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 26.12.2016.
 */
public class DetailPhotoFragment extends BaseFragment {

    public static final String TAG = "DetailPhotoFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(
                R.layout.fragment_detail_photo,
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

    }
}
